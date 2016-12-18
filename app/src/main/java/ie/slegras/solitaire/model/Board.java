package ie.slegras.solitaire.model;

import java.io.Serializable;

/**
 * Created by Sophie on 12/10/2016.
 */

public class Board implements Serializable {
    private int NUMBER_OF_PILES = 7;
    private Pile[] piles;
    private Pile[] validatedCards;
    private Deck deck;

    public Board() {
        piles = new Pile[NUMBER_OF_PILES];
        validatedCards = new Pile[Card.Suit.values().length];
        deck = new Deck();
    }

    public Board(Board anotherBoard) {
        this.piles = new Pile[NUMBER_OF_PILES];
        for (int i = 0; i < NUMBER_OF_PILES; i++) {
            piles[i] = new Pile(anotherBoard.getPiles()[i]);
        }
        this.validatedCards = new Pile[Card.Suit.values().length];
        for (int i = 0; i < anotherBoard.getValidatedCards().length; i++) {
            validatedCards[i] = new Pile(anotherBoard.getValidatedCards()[i]);
        }
        deck = new Deck(anotherBoard.getDeck());
    }

    public Pile[] getPiles() {
        return piles;
    }

    public Pile[] getValidatedCards() {
        return validatedCards;
    }

    public Deck getDeck() {
        return deck;
    }
}
