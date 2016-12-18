package ie.slegras.solitaire.model;

import java.io.Serializable;

/**
 * Created by sophielegras on 30/09/2016.
 */
public class Card implements Comparable, Serializable {

    public enum Suit {
        SPADE(" ♤"),
        HEART(" ♥"),
        DIAMOND(" ♦"),
        CLUB(" ♧");

        private String symbol;

        Suit(String symbol) {
            this.symbol = symbol;
        }

        @Override
        public String toString() {
            return symbol;
        }
    }

    public enum Value {
        AS("A"),
        TWO("2"),
        THREE("3"),
        FOUR("4"),
        FIVE("5"),
        SIX("6"),
        SEVEN("7"),
        EIGHT("8"),
        NINE("9"),
        TEN("10"),
        JACK("J"),
        QUEEN("Q"),
        KING("K");

        private String name;

        Value(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    private Value value;
    private Suit suit;

    public Card(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Card) {
            Card card = (Card) o;
            return value.equals(card.value) && suit.equals(card.suit);
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Object o) {
        final int lessThan = -1;
        final int equal = 0;
        final int greaterThan = 1;

        if (o instanceof Card) {
            Card card = (Card) o;
            if (this.equals(card)) {
                return equal;
            }
            if (this.value.ordinal() < card.value.ordinal()) {
                return lessThan;
            }
            return greaterThan;
        }
        return equal;
    }

    public Boolean isOppositeColor(Card other) {
        if(suit == Suit.HEART || suit == Suit.DIAMOND) {
            if (other.getSuit() == Suit.CLUB || other.getSuit() == Suit.SPADE) {
                return true;
            } else {
                return false;
            }
        } else {
            if (other.getSuit() == Suit.DIAMOND || other.getSuit() == Suit.HEART) {
                return true;
            } else {
                return false;
            }
        }
    }

    public String toString() {
        return value.toString().concat(suit.toString())  ;
    }

    public Value getValue() {
        return value;
    }

    public Suit getSuit() {
        return suit;
    }
}
