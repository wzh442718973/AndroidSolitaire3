package ie.slegras.solitaire.view;

import ie.slegras.solitaire.model.Card;
import ie.slegras.solitaire.model.Game;

/**
 * Created by Sophie on 16/11/2016.
 */

public class Linker {

    public Game deckAction(Game game) {
        game.drawCards();
        return game;
    }

    public Game spadeAction(Game game, Card card) {
        game.cardFromDeckIntoValidatedOnes(card, 0);
        for (int i = 0; i < 7; i++) {
            game.cardFromPileIntoValidatedOnes(card, i, 0);
        }
        return game;
    }

    public Game diamondAction(Game game, Card card) {
        game.cardFromDeckIntoValidatedOnes(card, 1);
        for (int i = 0; i < 7; i++) {
            game.cardFromPileIntoValidatedOnes(card, i, 1);
        }
        return game;
    }

    public Game clubAction(Game game, Card card) {
        game.cardFromDeckIntoValidatedOnes(card, 2);
        for (int i = 0; i < 7; i++) {
            game.cardFromPileIntoValidatedOnes(card, i, 2);
        }
        return game;
    }

    public Game heartAction(Game game, Card card) {
        game.cardFromDeckIntoValidatedOnes(card, 3);
        for (int i = 0; i < 7; i++) {
            game.cardFromPileIntoValidatedOnes(card, i, 3);
        }
        return game;
    }

    public Game pileAction(Game game, Card card, int index) {
        game.cardFromDeckIntoPile(card, index);
        for (int i = 0; i < 7; i++) {
            game.cardFromPileIntoPile(card, i, index);
        }
        return game;
    }
}
