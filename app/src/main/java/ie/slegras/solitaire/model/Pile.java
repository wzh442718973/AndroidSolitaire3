package ie.slegras.solitaire.model;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * Created by Sophie on 12/10/2016.
 */

public class Pile implements Serializable {
    private Deque<Card> cards;
    private Deque<Card> visible;

    public Deque<Card> getCards() {
        return cards;
    }

    public Deque<Card> getVisibleCards() {
        return visible;
    }

    public Pile() {
        cards = new ArrayDeque<>();
        visible = new ArrayDeque<>();
    }

    public Pile(Pile pile) {
        if (pile != null) {
            this.cards = new ArrayDeque<>(pile.getCards());
            this.visible = new ArrayDeque<>(pile.getVisibleCards());
        }
    }

    public void clearPile() {
        cards.clear();
        visible.clear();
    }

    public void addCard(Card card) {
        cards.push(card);
    }

    public void addVisibleCard(Card card) {
        visible.push(card);
    }

    public Boolean removeCard(Card card) {
        if (visible.contains(card)) {
            visible.remove(card);
            if (visible.size() == 0 && cards.size() > 0) {
                Card toChange = cards.pop();
                visible.add(toChange);
            }
            return true;
        } else {
            return false;
        }
    }

    public Deque<Card> getCardsUnderThisOne(Card card) {
        if (!visible.contains(card)) {
            return null;
        }
        Deque<Card> result = new ArrayDeque<>();
        ArrayList<Card> saveCards = new ArrayList<>();
        Card currentCard = visible.pop();
        while (!currentCard.equals(card)) {
            result.push(currentCard);
            saveCards.add(currentCard);
            currentCard = visible.pop();
        }
        result.push(card);
        saveCards.add(card);
        for (int i = saveCards.size() - 1; i >= 0; i--) {
            visible.push(saveCards.get(i));
        }
        return result;
    }
}
