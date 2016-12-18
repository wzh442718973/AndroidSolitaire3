package ie.slegras.solitaire;

import org.junit.Test;

import ie.slegras.solitaire.model.Board;
import ie.slegras.solitaire.model.Card;
import ie.slegras.solitaire.model.Deck;
import ie.slegras.solitaire.model.Game;
import ie.slegras.solitaire.model.Pile;

import static org.junit.Assert.assertEquals;

public class GameTest {
    private int NUMBER_OF_CARDS = 52;

    @Test
    public void initGame() throws Exception {
        Game game = new Game();
        game.initGame();
        printCurrentGameState(game);
        assertEquals(NUMBER_OF_CARDS, findTotalCards(game.getBoard()));

        Boolean repetition = testRepetitions(game.getBoard());
        assertEquals(repetition, false);
    }

    @Test
    public void initGameWithKnownCards() throws Exception {
        Game game = CardsLoader.init();
        printCurrentGameState(game);
        assertEquals(NUMBER_OF_CARDS, findTotalCards(game.getBoard()));

        Boolean repetition = testRepetitions(game.getBoard());
        assertEquals(repetition, false);
    }

    @Test
    public void drawCardsOnce() throws Exception {
        Game game = CardsLoader.init();
        game.drawCards();

        Game model = CardsLoader.gameWithDrawnCards();
        Boolean equal = areCardsEqual(game, model);
        assertEquals(true, equal);
    }

    @Test
    public void drawCardsTwice() throws Exception {
        Game game = CardsLoader.init();
        printCurrentGameState(game);
        game.drawCards();
        game.drawCards();

        Game model = CardsLoader.gameWithDrawnCardsTwice();
        Boolean equal = areCardsEqual(game, model);
        assertEquals(true, equal);
    }

    @Test
    public void addRightFirstCardFromPileToValidated() throws Exception {
        Game game = CardsLoader.init();
        Card toMove = game.getBoard().getPiles()[6].getVisibleCards().getFirst();
        game.cardFromPileIntoValidatedOnes(toMove, 6, toMove.getSuit().ordinal());

        Game model = CardsLoader.gameWithAValidatedCardFromPile();
        Boolean equal = areCardsEqual(game, model);
        assertEquals(true, equal);
    }

    @Test
    public void addRightSecondCardFromPileToValidated() throws Exception {
        Game game = CardsLoader.init();
        Card toMove = game.getBoard().getPiles()[6].getVisibleCards().getFirst();
        game.cardFromPileIntoValidatedOnes(toMove, 6, toMove.getSuit().ordinal());
        Card toMove2 = game.getBoard().getPiles()[5].getVisibleCards().getFirst();
        game.cardFromPileIntoValidatedOnes(toMove2, 5, toMove.getSuit().ordinal());

        Game model = CardsLoader.gameWithASecondValidatedCardFromPile();
        Boolean equal = areCardsEqual(game, model);
        assertEquals(true, equal);
    }

    @Test
    public void addWrongCardFromPileToValidated() throws Exception {
        Game game = CardsLoader.init();
        Card toMove = game.getBoard().getPiles()[5].getCards().getFirst();
        game.cardFromPileIntoValidatedOnes(toMove, 5, toMove.getSuit().ordinal());

        Game model = CardsLoader.init();
        Boolean equal = areCardsEqual(game, model);
        assertEquals(true, equal);
    }

    @Test
    public void addWrongCardToValidated2() throws Exception {
        Game game = CardsLoader.init();
        Card toMove = game.getBoard().getPiles()[4].getCards().getFirst();
        game.cardFromPileIntoValidatedOnes(toMove, 4, toMove.getSuit().ordinal());

        Game model = CardsLoader.init();
        Boolean equal = areCardsEqual(game, model);
        assertEquals(true, equal);
    }

    @Test
    public void addRightCardFromDeckToPile() throws Exception {
        Game game = CardsLoader.init();
        game.drawCards();
        Card toMove = game.getBoard().getDeck().getDrawnCards().getFirst();
        game.cardFromDeckIntoPile(toMove, 0);

        Game model = CardsLoader.gameWithACardFromDeckToPile();
        Boolean equal = areCardsEqual(game, model);
        assertEquals(true, equal);
    }

    @Test
    public void addWrongCardFromDeckToPile() throws Exception {
        Game game = CardsLoader.init();
        game.drawCards();
        Card toMove = game.getBoard().getDeck().getDrawnCards().getFirst();
        game.cardFromDeckIntoPile(toMove, 1);

        Game model = CardsLoader.gameWithDrawnCards();
        Boolean equal = areCardsEqual(game, model);
        assertEquals(true, equal);
    }

    @Test
    public void addRightCardFromDeckToValidated() throws Exception {
        Game game = CardsLoader.init2();
        game.drawCards();
        Card toMove = game.getBoard().getDeck().getDrawnCards().getFirst();
        game.cardFromDeckIntoValidatedOnes(toMove, 2);

        Game model = CardsLoader.gameWithCardFromDeckToValidated();
        Boolean equal = areCardsEqual(game, model);
        assertEquals(true, equal);
    }

    @Test
    public void addWrongCardFromDeckToValidated() throws Exception {
        Game game = CardsLoader.init();
        game.drawCards();
        Card toMove = game.getBoard().getDeck().getDrawnCards().getFirst();
        game.cardFromDeckIntoValidatedOnes(toMove, 1);

        Game model = CardsLoader.gameWithDrawnCards();
        Boolean equal = areCardsEqual(game, model);
        assertEquals(true, equal);
    }

    @Test
    public void reinitializeDeck() throws Exception {
        Game game = CardsLoader.gameWithNoMoreCardsToDraw();
        game.drawCards();

        Game model = CardsLoader.init();
        Boolean equal = areCardsEqual(game, model);
        assertEquals(true, equal);
    }

    @Test
    public void redrawAfterTwo() throws Exception {
        Game game = CardsLoader.init();
        game.drawCards();
        Card toMove = game.getBoard().getDeck().getDrawnCards().getFirst();
        game.cardFromDeckIntoPile(toMove, 0);
        game.drawCards();

        Game model = CardsLoader.specialRedraw();
        Boolean equal = areCardsEqual(game, model);
        assertEquals(true, equal);
    }

    @Test
    public void addCardFromPileToPile() throws Exception {
        Game game = CardsLoader.init3();
        Card toMove = game.getBoard().getPiles()[1].getVisibleCards().getFirst();
        game.cardFromPileIntoPile(toMove, 1, 2);

        Game model = CardsLoader.gameWithACardFromPileToPile();
        Boolean equal = areCardsEqual(game, model);
        assertEquals(true, equal);
    }

    @Test
    public void addSeveralCardFromPileToPile() throws Exception {
        Game game = CardsLoader.init4();
        Card toMove = new Card(Card.Value.SEVEN, Card.Suit.SPADE);
        game.cardFromPileIntoPile(toMove, 2, 6);

        Game model = CardsLoader.severalCardsFromPileToPile();
        Boolean equal = areCardsEqual(game, model);
        assertEquals(true, equal);
    }

    private void printCurrentGameState(Game game) {
        Board board = game.getBoard();
        System.out.println("Deck is : ");
        System.out.println(board.getDeck().getUnseen());
        System.out.println("Piles are : ");
        for (Pile pile : board.getPiles()) {
            if (pile != null) {
                System.out.println(pile.getVisibleCards());
                System.out.println(pile.getCards());
            }
        }
        System.out.println("Validated Cards are : ");
        for (Pile pile : board.getValidatedCards()) {
            if (pile != null) {
                System.out.println(pile.getCards());
            }
        }
    }

    private int findTotalCards(Board board) {
        int total = 0;
        total += board.getDeck().getUnseen().size() + board.getDeck().getAlreadySeen().size() + board.getDeck().getDrawnCards().size();
        for (Pile pile : board.getPiles()) {
            if (pile != null) {
                total += pile.getCards().size();
                total += pile.getVisibleCards().size();
            }
        }
        for (Pile pile : board.getValidatedCards()) {
            if (pile != null) {
                total += pile.getCards().size();
            }
        }
        return total;
    }

    private Boolean areCardsEqual(Game game1, Game game2) {
        //DECK
        Deck deck1 = game1.getBoard().getDeck();
        Deck deck2 = game2.getBoard().getDeck();
        if (decksHaveTheSameSize(deck1, deck2)) {
            return false;
        }
        for (int i = 0; i < deck1.getUnseen().size(); i++) {
            if (!deck1.getUnseen().pop().equals(deck2.getUnseen().pop())) {
                return false;
            }
        }
        for (int i = 0; i < deck1.getAlreadySeen().size(); i++) {
            if(!deck1.getAlreadySeen().pop().equals(deck2.getAlreadySeen().pop())) {
                return false;
            }
        }
        for (int i = 0; i < deck1.getDrawnCards().size(); i++) {
            if(!deck1.getDrawnCards().pop().equals(deck2.getDrawnCards().pop())) {
                return false;
            }
        }

        //PILES
        Pile[] piles1 = game1.getBoard().getPiles();
        Pile[] piles2 = game2.getBoard().getPiles();
        for (int i = 0; i < piles1.length; i++) {
            if (piles1[i].getCards().size() != piles2[i].getCards().size() || piles1[i].getVisibleCards().size() != piles2[i].getVisibleCards().size()) {
                return false;
            }
            for (int j = 0; j < piles1[i].getCards().size(); j++) {
                if (!piles1[i].getCards().pop().equals(piles2[i].getCards().pop())) {
                    return false;
                }
            }
            for (int j = 0; j < piles1[i].getVisibleCards().size(); j++) {
                if (!piles1[i].getVisibleCards().pop().equals(piles2[i].getVisibleCards().pop())) {
                    return false;
                }
            }
        }

        //VALIDATED CARDS
        Pile[] validated1 = game1.getBoard().getValidatedCards();
        Pile[] validated2 = game2.getBoard().getValidatedCards();
        for (int i = 0; i < validated1.length; i++) {
            if (validated1[i] != null && validated2[i] != null) {
                if (validated1[i].getCards().size() != validated2[i].getCards().size()) {
                    return false;
                }
                for (int j = 0; j < validated1[i].getCards().size(); j++) {
                    if (!validated1[i].getCards().pop().equals(validated2[i].getCards().pop())) {
                        return false;
                    }
                }
            } else if (!(validated1[i] == null && validated2[i] == null)) {
                return false;
            }
        }
        return true;
    }

    private boolean decksHaveTheSameSize(Deck deck1, Deck deck2) {
        return deck1.getUnseen().size() != deck2.getUnseen().size()
                || deck1.getDrawnCards().size() != deck2.getDrawnCards().size()
                || deck1.getAlreadySeen().size() != deck2.getAlreadySeen().size();
    }

    private Boolean testRepetitions(Board board) {
        Deck deck = board.getDeck();
        for (Card card : deck.getUnseen()) {
            if (deck.getDrawnCards().contains(card)) {
                return false;
            }
            if (deck.getAlreadySeen().contains(card)) {
                return false;
            }
            for (Pile pile : board.getPiles()) {
                if (pile != null && pile.getCards().contains(card)) {
                    return false;
                }
                if (pile != null && pile.getVisibleCards().contains(card)) {
                    return false;
                }
            }
            for (Pile pile : board.getValidatedCards()) {
                if (pile != null && pile.getCards().contains(card)) {
                    return false;
                }
            }
        }
        for (Card card : deck.getDrawnCards()) {
            if (deck.getAlreadySeen().contains(card)) {
                return false;
            }
            for (Pile pile : board.getPiles()) {
                if (pile != null && pile.getCards().contains(card)) {
                    return false;
                }
                if (pile != null && pile.getVisibleCards().contains(card)) {
                    return false;
                }
            }
            for (Pile pile : board.getValidatedCards()) {
                if (pile != null && pile.getCards().contains(card)) {
                    return false;
                }
            }
        }
        for (Card card : deck.getAlreadySeen()) {
            for (Pile pile : board.getPiles()) {
                if (pile != null && pile.getCards().contains(card)) {
                    return false;
                }
            }
            for (Pile pile : board.getValidatedCards()) {
                if (pile != null && pile.getCards().contains(card)) {
                    return false;
                }
                if (pile != null && pile.getVisibleCards().contains(card)) {
                    return false;
                }
            }
        }
        for (int i = 0; i < board.getPiles().length; i++) {
            for (Card card : board.getPiles()[i].getCards()) {
                if (board.getPiles()[i].getVisibleCards().contains(card)) {
                    return false;
                }
                for (int j = i + 1; j < board.getPiles().length; j++) {
                    if (board.getPiles()[j] != null && board.getPiles()[j].getCards().contains(card)) {
                        return false;
                    }
                    if (board.getPiles()[j] != null && board.getPiles()[j].getVisibleCards().contains(card)) {
                        return false;
                    }
                }
                for (Pile pile : board.getValidatedCards()) {
                    if (pile != null && pile.getCards().contains(card)) {
                        return false;
                    }
                }
            }
            for (Card card : board.getPiles()[i].getVisibleCards()) {
                for (int j = i + 1; j < board.getPiles().length; j++) {
                    if (board.getPiles()[j] != null && board.getPiles()[j].getVisibleCards().contains(card)) {
                        return false;
                    }
                }
                for (Pile pile : board.getValidatedCards()) {
                    if (pile != null && pile.getCards().contains(card)) {
                        return false;
                    }
                }
            }
        }
        for (int i = 0; i < board.getValidatedCards().length; i++) {
            if (board.getValidatedCards()[i] != null) {
                for (Card card : board.getValidatedCards()[i].getCards()) {
                    for (int j = i + 1; j < board.getPiles().length; j++) {
                        if (board.getValidatedCards()[j] != null && board.getValidatedCards()[j].getCards().contains(card)) {
                            return false;
                        }
                    }
                }
            }
        }
        return false;
    }
}