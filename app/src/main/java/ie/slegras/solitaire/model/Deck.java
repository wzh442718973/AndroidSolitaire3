package ie.slegras.solitaire.model;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by sophielegras on 30/09/2016.
 */
public class Deck implements Serializable {
    private Deque<Card> unseen;
    /*---------- DRAWN CARDS :
             - Position 2 : real seen card
             - Position 1 : drawn but we can't use it before 2
             - Position 0 : drawn but we can't use it before 1
    ----------------------------------*/
    private Deque<Card> drawnCards;
    private Deque<Card> alreadySeen;

    public Deck() {
        unseen = new ArrayDeque<>();
        drawnCards = new ArrayDeque<>();
        alreadySeen = new ArrayDeque<>();
    }

    public Deck(Deck anotherDeck) {
        Deque<Card> copiedUnseen = new ArrayDeque<>(anotherDeck.getUnseen());
        Deque<Card> copiedDrawnCards = new ArrayDeque<>(anotherDeck.getDrawnCards());
        Deque<Card> copiedAlreadySeen = new ArrayDeque<>(anotherDeck.getAlreadySeen());
        this.unseen = copiedUnseen;
        this.drawnCards = copiedDrawnCards;
        this.alreadySeen = copiedAlreadySeen;
    }

    public Deque<Card> drawCards() {
        if (unseen.size() == 0) {
            reInitializeDeck();
            return null;
        }
        reInitializeDrawnCards();
        while (drawnCards.size() < 3 && unseen.size() > 0) {
            Card drawnCard = unseen.pop();
            drawnCards.push(drawnCard);
        }
        return drawnCards;
    }

    private void reInitializeDrawnCards() {
        int size = drawnCards.size();
        for (int i = 0; i < size; i++) {
            Card card = drawnCards.removeLast();
            alreadySeen.push(card);
        }
        drawnCards.clear();
    }

    private void reInitializeDeck() {
        while(drawnCards.size() > 0) {
            Card card = drawnCards.pop();
            unseen.push(card);
        }
        while(alreadySeen.size() > 0) {
            Card card = alreadySeen.pop();
            unseen.push(card);
        }
        alreadySeen.clear();
    }

    public void addCard(Card card) {
        unseen.push(card);
    }

    public void addCardToAlreadySeen(Card card) {
        alreadySeen.push(card);
    }

    public void addCardToDrawnCards(Card card) {
        drawnCards.push(card);
    }

    public Boolean removeCard(Card card) {
        if (drawnCards.size() > 0) {
            Card drawnCard = drawnCards.pop();
            if (drawnCard.equals(card)) {
                return true;
            } else {
                drawnCards.push(drawnCard);
                return false;
            }
        } else {
            return false;
        }
    }

    public void clearDeck() {
        alreadySeen.clear();
        unseen.clear();
        drawnCards.clear();
    }

    public Deque<Card> getUnseen() {
        return unseen;
    }

    public Deque<Card> getAlreadySeen() {
        return alreadySeen;
    }

    public Deque<Card> getDrawnCards() {
        return drawnCards;
    }
}
