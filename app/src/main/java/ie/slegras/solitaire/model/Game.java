package ie.slegras.solitaire.model;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Random;

/**
 * Created by Sophie on 12/10/2016.
 */

public class Game implements Serializable {
    private Board board;
    private boolean gameInitialized;

    public Board getBoard() {
        return board;
    }

    public boolean isGameInitialized() { return gameInitialized; }

    public Game(Game anotherGame) {
        Board copiedBoard = new Board(anotherGame.getBoard());
        this.board = copiedBoard;
    }

    public Game() {
        this.board =new Board();
        gameInitialized = false;
    }

    /*-------------------------------------------------------------------------
    SIMPLE POSSIBLE ACTIONS FOR A PLAYER :
    - Draw three cards
    - Take a drawn card to a pile
    - Take a drawn card to the validated ones
    - Take a card in the pile to the validated ones (same function as above)
    -------------------------------------------------------------------------*/

    public Deque<Card> drawCards() {
        return board.getDeck().drawCards();
    }

    public void cardFromDeckIntoPile(Card card, int pileNumber) {
        if (getBoard().getPiles()[pileNumber] == null || getBoard().getPiles()[pileNumber].getVisibleCards().size() == 0) {
            if (!card.getValue().equals(Card.Value.KING)) {
                return;
            } else {
                if (getBoard().getDeck().removeCard(card)) {
                    board.getPiles()[pileNumber] = new Pile();
                    board.getPiles()[pileNumber].addVisibleCard(card);
                }
            }
        } else {
            Card lastCardInPile = getBoard().getPiles()[pileNumber].getVisibleCards().getFirst();
            if ((lastCardInPile.getValue().ordinal() - 1 != card.getValue().ordinal())
                    || !(lastCardInPile.isOppositeColor(card))) {
                return;
            }
            if (getBoard().getDeck().removeCard(card)) {
                board.getPiles()[pileNumber].addVisibleCard(card);
            }
        }
    }

    public void cardFromDeckIntoValidatedOnes(Card card, int validatedNumber) {
        if (getBoard().getValidatedCards()[validatedNumber] == null
                || getBoard().getValidatedCards()[validatedNumber].getCards() == null) {
            if (!card.getValue().equals(Card.Value.AS)) {
                return;
            } else {
                if (getBoard().getDeck().removeCard(card)) {
                    board.getValidatedCards()[validatedNumber] = new Pile();
                    board.getValidatedCards()[validatedNumber].addCard(card);
                }
            }
        } else {
            Card lastCardInValidated = getBoard().getValidatedCards()[validatedNumber].getCards().getFirst();
            if ((lastCardInValidated.getValue().ordinal() + 1 != card.getValue().ordinal())
                    || (lastCardInValidated.getSuit() != card.getSuit())) {
                return;
            }
            if (getBoard().getDeck().removeCard(card)) {
                board.getValidatedCards()[validatedNumber].addCard(card);
            }
        }
    }

    public void cardFromPileIntoValidatedOnes(Card card, int pileNumber, int validatedNumber) {
        if (getBoard().getValidatedCards()[validatedNumber] == null
                || getBoard().getValidatedCards()[validatedNumber].getCards() == null
                || getBoard().getValidatedCards()[validatedNumber].getCards().size() == 0) {
            if (!card.getValue().equals(Card.Value.AS)) {
                return;
            } else {
                if (getBoard().getPiles()[pileNumber].removeCard(card)) {
                    board.getValidatedCards()[validatedNumber] = new Pile();
                    board.getValidatedCards()[validatedNumber].addCard(card);
                }
            }
        } else {
            Card lastCardInValidated = getBoard().getValidatedCards()[validatedNumber].getCards().getFirst();
            if ((lastCardInValidated.getValue().ordinal() + 1 != card.getValue().ordinal())
                    || !(lastCardInValidated.getSuit().equals(card.getSuit()))) {
                return;
            }
            if (getBoard().getPiles()[pileNumber].removeCard(card)) {
                board.getValidatedCards()[validatedNumber].addCard(card);
            }
        }
    }

    public void cardFromPileIntoPile(Card card, int pileNumber, int pileNumber2) {
        if (pileNumber == pileNumber2) {
            return;
        }
        if (getBoard().getPiles()[pileNumber2] == null || getBoard().getPiles()[pileNumber2].getVisibleCards().size() == 0) {
            if (!card.getValue().equals(Card.Value.KING)) {
                return;
            } else {
                Deque<Card> cardsUnder = getBoard().getPiles()[pileNumber].getCardsUnderThisOne(card);
                if (cardsUnder == null) {
                    return;
                }
                board.getPiles()[pileNumber2] = new Pile();
                while (cardsUnder.size() > 0) {
                    Card currentCard = cardsUnder.pop();
                    getBoard().getPiles()[pileNumber].removeCard(currentCard);
                    board.getPiles()[pileNumber2].addVisibleCard(currentCard);
                }
            }
        } else {
            Card lastCardInPile2 = getBoard().getPiles()[pileNumber2].getVisibleCards().getFirst();
            if ((lastCardInPile2.getValue().ordinal() - 1 != card.getValue().ordinal())
                    || !(lastCardInPile2.isOppositeColor(card))) {
                return;
            }
            Deque<Card> cardsUnder = getBoard().getPiles()[pileNumber].getCardsUnderThisOne(card);
            if (cardsUnder == null) {
                return;
            }
            while (cardsUnder.size() > 0) {
                Card currentCard = cardsUnder.pop();
                getBoard().getPiles()[pileNumber].removeCard(currentCard);
                board.getPiles()[pileNumber2].addVisibleCard(currentCard);
            }
        }
    }

     /*---------------------------- GAMES ACTIONS ----------------------------*/

    public void initGame() {
        clearValidatedCards();
        List<Card> cardsLeft = new ArrayList<>();
        getEveryCard(cardsLeft);
        initDeck(cardsLeft);
        initPiles(cardsLeft);
        gameInitialized = true;
    }

    private void clearValidatedCards() {
        Pile[] validatedCards = board.getValidatedCards();
        for (Pile pile : validatedCards) {
            pile = new Pile();
            pile.clearPile();
        }
    }

    private void initPiles(List<Card> cardsLeft) {
        Pile[] piles = board.getPiles();
        for (int i = 0; i < piles.length; i++) {
            piles[i] = new Pile();
            piles[i].clearPile();
            for (int j = 0; j < i+1; j++) {
                //i+1 is the maximum number of cards in the pile
                Card card = getRandomCard(cardsLeft);
                cardsLeft.remove(card);
                piles[i].addCard(card);
            }
            Card toChange = piles[i].getCards().pop();
            piles[i].getVisibleCards().add(toChange);
        }
    }

    private void initDeck(List<Card> cardsLeft) {
        Deck deck = board.getDeck();
        deck.clearDeck();
        for (int i = 0; i < 24; i++) {
            Card card = getRandomCard(cardsLeft);
            cardsLeft.remove(card);
            deck.addCard(card);
        }
    }

    private void getEveryCard(List<Card> cardsLeft) {
        for (int value = 0; value < 13; value++) {
            for (int suit = 0; suit < 4; suit++) {
                Card card = new Card(Card.Value.values()[value], Card.Suit.values()[suit]);
                cardsLeft.add(card);
            }
        }
    }

    @NonNull
    private Card getRandomCard(List<Card> cardsLeft) {
        Random random = new Random();
        int randomNumber = random.nextInt((cardsLeft.size()));
        Card card = cardsLeft.get(randomNumber);
        return card;
    }
}
