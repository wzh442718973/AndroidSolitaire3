package ie.slegras.solitaire.view;

import ie.slegras.solitaire.model.Card;
import ie.slegras.solitaire.model.Game;
import ie.slegras.solitaire.model.Pile;

/**
 * Created by Sophie on 26/11/2016.
 */

public class ArtificialIntelligence {

    public Boolean lookIfGameLost(Game game) {
        if (game.isGameInitialized()) {
            Game copy = new Game(game);

            //STEP 1 : DECK : every visible Card
            if (copy.getBoard().getDeck() != null
                    && copy.getBoard().getDeck().getDrawnCards() != null) {

                Card currentDeckCard = copy.getBoard().getDeck().getDrawnCards().peek();
                while(copy.getBoard().getDeck().getDrawnCards().size() != 0) {
                    for (int i = 0; i < copy.getBoard().getPiles().length; i++) {

                        copy.cardFromDeckIntoPile(currentDeckCard, i);
                        if (i < 4){
                            copy.cardFromDeckIntoValidatedOnes(currentDeckCard, i);
                        }
                        if (copy.getBoard().getDeck().getDrawnCards().size() == 0 ||
                                (copy.getBoard().getDeck().getDrawnCards().size() != 0
                                        && copy.getBoard().getDeck().getDrawnCards().peek() != currentDeckCard)) {
                            System.out.println("DECK");
                            System.out.println(currentDeckCard);
                            System.out.println(i);
                            return false;
                        }

                    }
                    copy.drawCards();
                    currentDeckCard = copy.getBoard().getDeck().getDrawnCards().peek();
                }
                copy.drawCards();
                currentDeckCard = copy.getBoard().getDeck().getDrawnCards().peek();

                while(copy.getBoard().getDeck().getDrawnCards().size() != 0) {
                    for (int i = 0; i < copy.getBoard().getPiles().length; i++) {

                        copy.cardFromDeckIntoPile(currentDeckCard, i);
                        if (i < 4){
                            copy.cardFromDeckIntoValidatedOnes(currentDeckCard, i);
                        }
                        if (copy.getBoard().getDeck().getDrawnCards().size() == 0 ||
                                (copy.getBoard().getDeck().getDrawnCards().size() != 0
                                        && copy.getBoard().getDeck().getDrawnCards().peek() != currentDeckCard)) {
                            System.out.println("DECK");
                            System.out.println(currentDeckCard);
                            System.out.println(i);
                            return false;
                        }

                    }
                    copy.drawCards();
                    currentDeckCard = copy.getBoard().getDeck().getDrawnCards().peek();
                }


                copy.drawCards();
                currentDeckCard = copy.getBoard().getDeck().getDrawnCards().peek();

                while(copy.getBoard().getDeck().getDrawnCards().size() != 0) {
                    for (int i = 0; i < copy.getBoard().getPiles().length; i++) {

                        copy.cardFromDeckIntoPile(currentDeckCard, i);
                        if (i < 4){
                            copy.cardFromDeckIntoValidatedOnes(currentDeckCard, i);
                        }
                        if (copy.getBoard().getDeck().getDrawnCards().size() == 0 ||
                                (copy.getBoard().getDeck().getDrawnCards().size() != 0
                                        && copy.getBoard().getDeck().getDrawnCards().peek() != currentDeckCard)) {
                            System.out.println("DECK");
                            System.out.println(currentDeckCard);
                            System.out.println(i);
                            return false;
                        }

                    }
                    copy.drawCards();
                    currentDeckCard = copy.getBoard().getDeck().getDrawnCards().peek();
                }
            }

            //STEP 2 : PILES : Every first visible card
            for (int i = 0; i < copy.getBoard().getPiles().length; i++) {
                if (copy.getBoard().getPiles()[i].getVisibleCards() != null
                        && copy.getBoard().getPiles()[i].getVisibleCards().size() != 0) {
                    Card currentCard = copy.getBoard().getPiles()[i].getVisibleCards().getLast();
                    for (int j = 0; j < copy.getBoard().getPiles().length; j++) {
                        copy.cardFromPileIntoPile(currentCard, i, j);
                        if (copy.getBoard().getPiles()[i].getVisibleCards() != null
                                && copy.getBoard().getPiles()[i].getVisibleCards().size() != 0
                                && copy.getBoard().getPiles()[i].getVisibleCards().getLast() != currentCard) {
                            System.out.println("PILE TO PILE");
                            System.out.println(i);
                            System.out.println(j);
                            return false;
                        }
                    }
                }

            }
            for (int i = 0; i < copy.getBoard().getPiles().length; i++) {
                if (copy.getBoard().getPiles()[i].getVisibleCards() != null
                        && copy.getBoard().getPiles()[i].getVisibleCards().size() != 0) {
                    Card currentCard = copy.getBoard().getPiles()[i].getVisibleCards().getFirst();
                    for (int j = 0; j < copy.getBoard().getValidatedCards().length; j++) {
                        if (copy.getBoard().getPiles()[i].getVisibleCards().size() != 0) {
                            copy.cardFromPileIntoValidatedOnes(currentCard, i, j);
                            if (copy.getBoard().getPiles()[i].getVisibleCards() != null
                                    && copy.getBoard().getPiles()[i].getVisibleCards().getFirst() != currentCard) {
                                System.out.println("PILE TO VALIDATED");
                                System.out.println(i);
                                System.out.println(j);
                                return false;
                            }
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    public Boolean lookIfGameWon(Game game) {
        Pile[] validated = game.getBoard().getValidatedCards();
        for (int i = 0; i < validated.length; i++) {
            if (validated[i] == null || validated[i].getCards() == null || validated[i].getCards().size() == 0) {
                return false;
            }
            if (validated[i].getCards().peek().getValue() != Card.Value.KING) {
                return false;
            }
        }
        return true;
    }
}
