package ie.slegras.solitaire;

import ie.slegras.solitaire.model.Game;

import ie.slegras.solitaire.model.Card;
import ie.slegras.solitaire.model.Deck;
import ie.slegras.solitaire.model.Pile;

/**
 * Created by Sophie on 15/10/2016.
 */

public class CardsLoader {

    public static Game init() {
        Game game = new Game();

        //DECK
        addCardToDeck(game.getBoard().getDeck(), Card.Value.AS, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.TEN, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.NINE, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FIVE, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.THREE, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.JACK, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FOUR, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.AS, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FOUR, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.TWO, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.SEVEN, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.SEVEN, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.THREE, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.EIGHT, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.TEN, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.THREE, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.AS, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.SIX, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.NINE, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FIVE, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.KING, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FIVE, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.QUEEN, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.SIX, Card.Suit.CLUB);


        //PILES
        game.getBoard().getPiles()[0] = new Pile();
        addCardToVisiblePile(game.getBoard().getPiles()[0], Card.Value.SIX, Card.Suit.HEART);

        game.getBoard().getPiles()[1] = new Pile();
        addCardToPile(game.getBoard().getPiles()[1], Card.Value.THREE, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[1], Card.Value.SIX, Card.Suit.SPADE);

        game.getBoard().getPiles()[2] = new Pile();
        addCardToPile(game.getBoard().getPiles()[2], Card.Value.TEN, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[2], Card.Value.QUEEN, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[2], Card.Value.SEVEN, Card.Suit.SPADE);

        game.getBoard().getPiles()[3] = new Pile();
        addCardToPile(game.getBoard().getPiles()[3], Card.Value.FOUR, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[3], Card.Value.QUEEN, Card.Suit.CLUB);
        addCardToPile(game.getBoard().getPiles()[3],Card.Value.JACK, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[3], Card.Value.NINE, Card.Suit.DIAMOND);

        game.getBoard().getPiles()[4] = new Pile();
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.TEN, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.KING, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.JACK, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.TWO, Card.Suit.CLUB);
        addCardToVisiblePile(game.getBoard().getPiles()[4], Card.Value.SEVEN, Card.Suit.CLUB);

        game.getBoard().getPiles()[5] = new Pile();
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.FIVE, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.FOUR, Card.Suit.CLUB);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.QUEEN, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.JACK, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.KING, Card.Suit.HEART);
        addCardToVisiblePile(game.getBoard().getPiles()[5], Card.Value.TWO, Card.Suit.SPADE);

        game.getBoard().getPiles()[6] = new Pile();
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.TWO, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[6],Card.Value.EIGHT, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.NINE, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.EIGHT, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.EIGHT, Card.Suit.CLUB);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.KING, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[6], Card.Value.AS, Card.Suit.SPADE);

        //VALIDATED

        return game;
    }

    public static Game gameWithDrawnCards() {
        Game game = new Game();

        //DECK
        addCardToDeck(game.getBoard().getDeck(), Card.Value.AS, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.TEN, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.NINE, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FIVE, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.THREE, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.JACK, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FOUR, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.AS, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FOUR, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.TWO, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.SEVEN, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.SEVEN, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.THREE, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.EIGHT, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.TEN, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.THREE, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.AS, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.SIX, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.NINE, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FIVE, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.KING, Card.Suit.CLUB);

        addCardToDrawnCards(game.getBoard().getDeck(), Card.Value.SIX, Card.Suit.CLUB);
        addCardToDrawnCards(game.getBoard().getDeck(), Card.Value.QUEEN, Card.Suit.HEART);
        addCardToDrawnCards(game.getBoard().getDeck(), Card.Value.FIVE, Card.Suit.SPADE);


        //PILES
        game.getBoard().getPiles()[0] = new Pile();
        addCardToVisiblePile(game.getBoard().getPiles()[0], Card.Value.SIX, Card.Suit.HEART);

        game.getBoard().getPiles()[1] = new Pile();
        addCardToPile(game.getBoard().getPiles()[1], Card.Value.THREE, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[1], Card.Value.SIX, Card.Suit.SPADE);

        game.getBoard().getPiles()[2] = new Pile();
        addCardToPile(game.getBoard().getPiles()[2], Card.Value.TEN, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[2], Card.Value.QUEEN, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[2], Card.Value.SEVEN, Card.Suit.SPADE);

        game.getBoard().getPiles()[3] = new Pile();
        addCardToPile(game.getBoard().getPiles()[3], Card.Value.FOUR, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[3], Card.Value.QUEEN, Card.Suit.CLUB);
        addCardToPile(game.getBoard().getPiles()[3],Card.Value.JACK, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[3], Card.Value.NINE, Card.Suit.DIAMOND);

        game.getBoard().getPiles()[4] = new Pile();
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.TEN, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.KING, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.JACK, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.TWO, Card.Suit.CLUB);
        addCardToVisiblePile(game.getBoard().getPiles()[4], Card.Value.SEVEN, Card.Suit.CLUB);

        game.getBoard().getPiles()[5] = new Pile();
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.FIVE, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.FOUR, Card.Suit.CLUB);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.QUEEN, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.JACK, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.KING, Card.Suit.HEART);
        addCardToVisiblePile(game.getBoard().getPiles()[5], Card.Value.TWO, Card.Suit.SPADE);

        game.getBoard().getPiles()[6] = new Pile();
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.TWO, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[6],Card.Value.EIGHT, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.NINE, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.EIGHT, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.EIGHT, Card.Suit.CLUB);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.KING, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[6], Card.Value.AS, Card.Suit.SPADE);

        //VALIDATED

        return game;
    }

    public static Game gameWithDrawnCardsTwice() {
        Game game = new Game();

        //DECK
        addCardToDeck(game.getBoard().getDeck(), Card.Value.AS, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.TEN, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.NINE, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FIVE, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.THREE, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.JACK, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FOUR, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.AS, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FOUR, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.TWO, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.SEVEN, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.SEVEN, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.THREE, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.EIGHT, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.TEN, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.THREE, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.AS, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.SIX, Card.Suit.DIAMOND);

        addCardToDrawnCards(game.getBoard().getDeck(), Card.Value.KING, Card.Suit.CLUB);
        addCardToDrawnCards(game.getBoard().getDeck(), Card.Value.FIVE, Card.Suit.CLUB);
        addCardToDrawnCards(game.getBoard().getDeck(), Card.Value.NINE, Card.Suit.CLUB);

        addCardToAlreadySeen(game.getBoard().getDeck(), Card.Value.SIX, Card.Suit.CLUB);
        addCardToAlreadySeen(game.getBoard().getDeck(), Card.Value.QUEEN, Card.Suit.HEART);
        addCardToAlreadySeen(game.getBoard().getDeck(), Card.Value.FIVE, Card.Suit.SPADE);


        //PILES
        game.getBoard().getPiles()[0] = new Pile();
        addCardToVisiblePile(game.getBoard().getPiles()[0], Card.Value.SIX, Card.Suit.HEART);

        game.getBoard().getPiles()[1] = new Pile();
        addCardToPile(game.getBoard().getPiles()[1], Card.Value.THREE, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[1], Card.Value.SIX, Card.Suit.SPADE);

        game.getBoard().getPiles()[2] = new Pile();
        addCardToPile(game.getBoard().getPiles()[2], Card.Value.TEN, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[2], Card.Value.QUEEN, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[2], Card.Value.SEVEN, Card.Suit.SPADE);

        game.getBoard().getPiles()[3] = new Pile();
        addCardToPile(game.getBoard().getPiles()[3], Card.Value.FOUR, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[3], Card.Value.QUEEN, Card.Suit.CLUB);
        addCardToPile(game.getBoard().getPiles()[3],Card.Value.JACK, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[3], Card.Value.NINE, Card.Suit.DIAMOND);

        game.getBoard().getPiles()[4] = new Pile();
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.TEN, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.KING, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.JACK, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.TWO, Card.Suit.CLUB);
        addCardToVisiblePile(game.getBoard().getPiles()[4], Card.Value.SEVEN, Card.Suit.CLUB);

        game.getBoard().getPiles()[5] = new Pile();
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.FIVE, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.FOUR, Card.Suit.CLUB);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.QUEEN, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.JACK, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.KING, Card.Suit.HEART);
        addCardToVisiblePile(game.getBoard().getPiles()[5], Card.Value.TWO, Card.Suit.SPADE);

        game.getBoard().getPiles()[6] = new Pile();
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.TWO, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[6],Card.Value.EIGHT, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.NINE, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.EIGHT, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.EIGHT, Card.Suit.CLUB);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.KING, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[6], Card.Value.AS, Card.Suit.SPADE);

        //VALIDATED

        return game;
    }

    public static Game gameWithAValidatedCardFromPile() {
        Game game = new Game();

        //DECK
        addCardToDeck(game.getBoard().getDeck(), Card.Value.AS, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.TEN, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.NINE, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FIVE, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.THREE, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.JACK, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FOUR, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.AS, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FOUR, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.TWO, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.SEVEN, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.SEVEN, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.THREE, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.EIGHT, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.TEN, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.THREE, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.AS, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.SIX, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.NINE, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FIVE, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.KING, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FIVE, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.QUEEN, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.SIX, Card.Suit.CLUB);


        //PILES
        game.getBoard().getPiles()[0] = new Pile();
        addCardToVisiblePile(game.getBoard().getPiles()[0], Card.Value.SIX, Card.Suit.HEART);

        game.getBoard().getPiles()[1] = new Pile();
        addCardToPile(game.getBoard().getPiles()[1], Card.Value.THREE, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[1], Card.Value.SIX, Card.Suit.SPADE);

        game.getBoard().getPiles()[2] = new Pile();
        addCardToPile(game.getBoard().getPiles()[2], Card.Value.TEN, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[2], Card.Value.QUEEN, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[2], Card.Value.SEVEN, Card.Suit.SPADE);

        game.getBoard().getPiles()[3] = new Pile();
        addCardToPile(game.getBoard().getPiles()[3], Card.Value.FOUR, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[3], Card.Value.QUEEN, Card.Suit.CLUB);
        addCardToPile(game.getBoard().getPiles()[3],Card.Value.JACK, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[3], Card.Value.NINE, Card.Suit.DIAMOND);

        game.getBoard().getPiles()[4] = new Pile();
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.TEN, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.KING, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.JACK, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.TWO, Card.Suit.CLUB);
        addCardToVisiblePile(game.getBoard().getPiles()[4], Card.Value.SEVEN, Card.Suit.CLUB);

        game.getBoard().getPiles()[5] = new Pile();
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.FIVE, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.FOUR, Card.Suit.CLUB);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.QUEEN, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.JACK, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.KING, Card.Suit.HEART);
        addCardToVisiblePile(game.getBoard().getPiles()[5], Card.Value.TWO, Card.Suit.SPADE);

        game.getBoard().getPiles()[6] = new Pile();
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.TWO, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[6],Card.Value.EIGHT, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.NINE, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.EIGHT, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.EIGHT, Card.Suit.CLUB);
        addCardToVisiblePile(game.getBoard().getPiles()[6], Card.Value.KING, Card.Suit.SPADE);

        //VALIDATED
        game.getBoard().getValidatedCards()[0] = new Pile();
        addCardToValidated(game.getBoard().getValidatedCards()[0], Card.Value.AS, Card.Suit.SPADE);

        return game;
    }

    public static Game gameWithASecondValidatedCardFromPile() {
        Game game = new Game();

        //DECK
        addCardToDeck(game.getBoard().getDeck(), Card.Value.AS, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.TEN, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.NINE, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FIVE, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.THREE, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.JACK, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FOUR, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.AS, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FOUR, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.TWO, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.SEVEN, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.SEVEN, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.THREE, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.EIGHT, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.TEN, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.THREE, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.AS, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.SIX, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.NINE, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FIVE, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.KING, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FIVE, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.QUEEN, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.SIX, Card.Suit.CLUB);


        //PILES
        game.getBoard().getPiles()[0] = new Pile();
        addCardToVisiblePile(game.getBoard().getPiles()[0], Card.Value.SIX, Card.Suit.HEART);

        game.getBoard().getPiles()[1] = new Pile();
        addCardToPile(game.getBoard().getPiles()[1], Card.Value.THREE, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[1], Card.Value.SIX, Card.Suit.SPADE);

        game.getBoard().getPiles()[2] = new Pile();
        addCardToPile(game.getBoard().getPiles()[2], Card.Value.TEN, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[2], Card.Value.QUEEN, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[2], Card.Value.SEVEN, Card.Suit.SPADE);

        game.getBoard().getPiles()[3] = new Pile();
        addCardToPile(game.getBoard().getPiles()[3], Card.Value.FOUR, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[3], Card.Value.QUEEN, Card.Suit.CLUB);
        addCardToPile(game.getBoard().getPiles()[3],Card.Value.JACK, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[3], Card.Value.NINE, Card.Suit.DIAMOND);

        game.getBoard().getPiles()[4] = new Pile();
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.TEN, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.KING, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.JACK, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.TWO, Card.Suit.CLUB);
        addCardToVisiblePile(game.getBoard().getPiles()[4], Card.Value.SEVEN, Card.Suit.CLUB);

        game.getBoard().getPiles()[5] = new Pile();
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.FIVE, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.FOUR, Card.Suit.CLUB);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.QUEEN, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.JACK, Card.Suit.HEART);
        addCardToVisiblePile(game.getBoard().getPiles()[5], Card.Value.KING, Card.Suit.HEART);

        game.getBoard().getPiles()[6] = new Pile();
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.TWO, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[6],Card.Value.EIGHT, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.NINE, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.EIGHT, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.EIGHT, Card.Suit.CLUB);
        addCardToVisiblePile(game.getBoard().getPiles()[6], Card.Value.KING, Card.Suit.SPADE);

        //VALIDATED
        game.getBoard().getValidatedCards()[0] = new Pile();
        addCardToValidated(game.getBoard().getValidatedCards()[0], Card.Value.AS, Card.Suit.SPADE);
        addCardToValidated(game.getBoard().getValidatedCards()[0], Card.Value.TWO, Card.Suit.SPADE);

        return game;
    }

    public static Game gameWithACardFromDeckToPile() {
        Game game = new Game();

        //DECK
        addCardToDeck(game.getBoard().getDeck(), Card.Value.AS, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.TEN, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.NINE, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FIVE, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.THREE, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.JACK, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FOUR, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.AS, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FOUR, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.TWO, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.SEVEN, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.SEVEN, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.THREE, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.EIGHT, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.TEN, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.THREE, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.AS, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.SIX, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.NINE, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FIVE, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.KING, Card.Suit.CLUB);

        addCardToDrawnCards(game.getBoard().getDeck(), Card.Value.SIX, Card.Suit.CLUB);
        addCardToDrawnCards(game.getBoard().getDeck(), Card.Value.QUEEN, Card.Suit.HEART);


        //PILES
        game.getBoard().getPiles()[0] = new Pile();
        addCardToVisiblePile(game.getBoard().getPiles()[0], Card.Value.SIX, Card.Suit.HEART);
        addCardToVisiblePile(game.getBoard().getPiles()[0], Card.Value.FIVE, Card.Suit.SPADE);

        game.getBoard().getPiles()[1] = new Pile();
        addCardToPile(game.getBoard().getPiles()[1], Card.Value.THREE, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[1], Card.Value.SIX, Card.Suit.SPADE);

        game.getBoard().getPiles()[2] = new Pile();
        addCardToPile(game.getBoard().getPiles()[2], Card.Value.TEN, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[2], Card.Value.QUEEN, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[2], Card.Value.SEVEN, Card.Suit.SPADE);

        game.getBoard().getPiles()[3] = new Pile();
        addCardToPile(game.getBoard().getPiles()[3], Card.Value.FOUR, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[3], Card.Value.QUEEN, Card.Suit.CLUB);
        addCardToPile(game.getBoard().getPiles()[3],Card.Value.JACK, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[3], Card.Value.NINE, Card.Suit.DIAMOND);

        game.getBoard().getPiles()[4] = new Pile();
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.TEN, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.KING, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.JACK, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.TWO, Card.Suit.CLUB);
        addCardToVisiblePile(game.getBoard().getPiles()[4], Card.Value.SEVEN, Card.Suit.CLUB);

        game.getBoard().getPiles()[5] = new Pile();
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.FIVE, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.FOUR, Card.Suit.CLUB);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.QUEEN, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.JACK, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.KING, Card.Suit.HEART);
        addCardToVisiblePile(game.getBoard().getPiles()[5], Card.Value.TWO, Card.Suit.SPADE);

        game.getBoard().getPiles()[6] = new Pile();
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.TWO, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[6],Card.Value.EIGHT, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.NINE, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.EIGHT, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.EIGHT, Card.Suit.CLUB);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.KING, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[6], Card.Value.AS, Card.Suit.SPADE);

        //VALIDATED

        return game;
    }

    public static Game init2() {
        Game game = new Game();

        //DECK
        addCardToDeck(game.getBoard().getDeck(), Card.Value.TEN, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.NINE, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FIVE, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.THREE, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.JACK, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FOUR, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.AS, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FOUR, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.TWO, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.SEVEN, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.SEVEN, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.THREE, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.EIGHT, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.TEN, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.THREE, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.AS, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.SIX, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.NINE, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FIVE, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.KING, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FIVE, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.AS, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.QUEEN, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.SIX, Card.Suit.CLUB);


        //PILES
        game.getBoard().getPiles()[0] = new Pile();
        addCardToVisiblePile(game.getBoard().getPiles()[0], Card.Value.SIX, Card.Suit.HEART);

        game.getBoard().getPiles()[1] = new Pile();
        addCardToPile(game.getBoard().getPiles()[1], Card.Value.THREE, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[1], Card.Value.SIX, Card.Suit.SPADE);

        game.getBoard().getPiles()[2] = new Pile();
        addCardToPile(game.getBoard().getPiles()[2], Card.Value.TEN, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[2], Card.Value.QUEEN, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[2], Card.Value.SEVEN, Card.Suit.SPADE);

        game.getBoard().getPiles()[3] = new Pile();
        addCardToPile(game.getBoard().getPiles()[3], Card.Value.FOUR, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[3], Card.Value.QUEEN, Card.Suit.CLUB);
        addCardToPile(game.getBoard().getPiles()[3],Card.Value.JACK, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[3], Card.Value.NINE, Card.Suit.DIAMOND);

        game.getBoard().getPiles()[4] = new Pile();
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.TEN, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.KING, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.JACK, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.TWO, Card.Suit.CLUB);
        addCardToVisiblePile(game.getBoard().getPiles()[4], Card.Value.SEVEN, Card.Suit.CLUB);

        game.getBoard().getPiles()[5] = new Pile();
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.FIVE, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.FOUR, Card.Suit.CLUB);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.QUEEN, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.JACK, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.KING, Card.Suit.HEART);
        addCardToVisiblePile(game.getBoard().getPiles()[5], Card.Value.TWO, Card.Suit.SPADE);

        game.getBoard().getPiles()[6] = new Pile();
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.TWO, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[6],Card.Value.EIGHT, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.NINE, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.EIGHT, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.EIGHT, Card.Suit.CLUB);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.KING, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[6], Card.Value.AS, Card.Suit.SPADE);

        //VALIDATED

        return game;
    }

    public static Game gameWithCardFromDeckToValidated() {
        Game game = new Game();

        //DECK
        addCardToDeck(game.getBoard().getDeck(), Card.Value.TEN, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.NINE, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FIVE, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.THREE, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.JACK, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FOUR, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.AS, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FOUR, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.TWO, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.SEVEN, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.SEVEN, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.THREE, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.EIGHT, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.TEN, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.THREE, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.AS, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.SIX, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.NINE, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FIVE, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.KING, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FIVE, Card.Suit.SPADE);

        addCardToDrawnCards(game.getBoard().getDeck(), Card.Value.SIX, Card.Suit.CLUB);
        addCardToDrawnCards(game.getBoard().getDeck(), Card.Value.QUEEN, Card.Suit.HEART);

        //PILES
        game.getBoard().getPiles()[0] = new Pile();
        addCardToVisiblePile(game.getBoard().getPiles()[0], Card.Value.SIX, Card.Suit.HEART);

        game.getBoard().getPiles()[1] = new Pile();
        addCardToPile(game.getBoard().getPiles()[1], Card.Value.THREE, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[1], Card.Value.SIX, Card.Suit.SPADE);

        game.getBoard().getPiles()[2] = new Pile();
        addCardToPile(game.getBoard().getPiles()[2], Card.Value.TEN, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[2], Card.Value.QUEEN, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[2], Card.Value.SEVEN, Card.Suit.SPADE);

        game.getBoard().getPiles()[3] = new Pile();
        addCardToPile(game.getBoard().getPiles()[3], Card.Value.FOUR, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[3], Card.Value.QUEEN, Card.Suit.CLUB);
        addCardToPile(game.getBoard().getPiles()[3],Card.Value.JACK, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[3], Card.Value.NINE, Card.Suit.DIAMOND);

        game.getBoard().getPiles()[4] = new Pile();
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.TEN, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.KING, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.JACK, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.TWO, Card.Suit.CLUB);
        addCardToVisiblePile(game.getBoard().getPiles()[4], Card.Value.SEVEN, Card.Suit.CLUB);

        game.getBoard().getPiles()[5] = new Pile();
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.FIVE, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.FOUR, Card.Suit.CLUB);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.QUEEN, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.JACK, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.KING, Card.Suit.HEART);
        addCardToVisiblePile(game.getBoard().getPiles()[5], Card.Value.TWO, Card.Suit.SPADE);

        game.getBoard().getPiles()[6] = new Pile();
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.TWO, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[6],Card.Value.EIGHT, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.NINE, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.EIGHT, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.EIGHT, Card.Suit.CLUB);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.KING, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[6], Card.Value.AS, Card.Suit.SPADE);

        //VALIDATED
        game.getBoard().getValidatedCards()[2] = new Pile();
        addCardToValidated(game.getBoard().getValidatedCards()[2], Card.Value.AS, Card.Suit.DIAMOND);

        return game;
    }

    public static Game gameWithNoMoreCardsToDraw() {
        Game game = new Game();

        //DECK
        addCardToAlreadySeen(game.getBoard().getDeck(), Card.Value.SIX, Card.Suit.CLUB);
        addCardToAlreadySeen(game.getBoard().getDeck(), Card.Value.QUEEN, Card.Suit.HEART);
        addCardToAlreadySeen(game.getBoard().getDeck(), Card.Value.FIVE, Card.Suit.SPADE);
        addCardToAlreadySeen(game.getBoard().getDeck(), Card.Value.KING, Card.Suit.CLUB);
        addCardToAlreadySeen(game.getBoard().getDeck(), Card.Value.FIVE, Card.Suit.CLUB);
        addCardToAlreadySeen(game.getBoard().getDeck(), Card.Value.NINE, Card.Suit.CLUB);
        addCardToAlreadySeen(game.getBoard().getDeck(), Card.Value.SIX, Card.Suit.DIAMOND);
        addCardToAlreadySeen(game.getBoard().getDeck(), Card.Value.AS, Card.Suit.HEART);
        addCardToAlreadySeen(game.getBoard().getDeck(), Card.Value.THREE, Card.Suit.CLUB);
        addCardToAlreadySeen(game.getBoard().getDeck(), Card.Value.TEN, Card.Suit.CLUB);
        addCardToAlreadySeen(game.getBoard().getDeck(), Card.Value.EIGHT, Card.Suit.SPADE);
        addCardToAlreadySeen(game.getBoard().getDeck(), Card.Value.THREE, Card.Suit.DIAMOND);
        addCardToAlreadySeen(game.getBoard().getDeck(), Card.Value.SEVEN, Card.Suit.DIAMOND);
        addCardToAlreadySeen(game.getBoard().getDeck(), Card.Value.SEVEN, Card.Suit.HEART);
        addCardToAlreadySeen(game.getBoard().getDeck(), Card.Value.TWO, Card.Suit.HEART);
        addCardToAlreadySeen(game.getBoard().getDeck(), Card.Value.FOUR, Card.Suit.SPADE);
        addCardToAlreadySeen(game.getBoard().getDeck(), Card.Value.AS, Card.Suit.CLUB);
        addCardToAlreadySeen(game.getBoard().getDeck(), Card.Value.FOUR, Card.Suit.HEART);
        addCardToAlreadySeen(game.getBoard().getDeck(), Card.Value.JACK, Card.Suit.CLUB);
        addCardToAlreadySeen(game.getBoard().getDeck(), Card.Value.THREE, Card.Suit.HEART);
        addCardToAlreadySeen(game.getBoard().getDeck(), Card.Value.FIVE, Card.Suit.DIAMOND);
        addCardToAlreadySeen(game.getBoard().getDeck(), Card.Value.NINE, Card.Suit.SPADE);
        addCardToAlreadySeen(game.getBoard().getDeck(), Card.Value.TEN, Card.Suit.SPADE);
        addCardToAlreadySeen(game.getBoard().getDeck(), Card.Value.AS, Card.Suit.DIAMOND);

        //PILES
        game.getBoard().getPiles()[0] = new Pile();
        addCardToVisiblePile(game.getBoard().getPiles()[0], Card.Value.SIX, Card.Suit.HEART);

        game.getBoard().getPiles()[1] = new Pile();
        addCardToPile(game.getBoard().getPiles()[1], Card.Value.THREE, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[1], Card.Value.SIX, Card.Suit.SPADE);

        game.getBoard().getPiles()[2] = new Pile();
        addCardToPile(game.getBoard().getPiles()[2], Card.Value.TEN, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[2], Card.Value.QUEEN, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[2], Card.Value.SEVEN, Card.Suit.SPADE);

        game.getBoard().getPiles()[3] = new Pile();
        addCardToPile(game.getBoard().getPiles()[3], Card.Value.FOUR, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[3], Card.Value.QUEEN, Card.Suit.CLUB);
        addCardToPile(game.getBoard().getPiles()[3],Card.Value.JACK, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[3], Card.Value.NINE, Card.Suit.DIAMOND);

        game.getBoard().getPiles()[4] = new Pile();
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.TEN, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.KING, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.JACK, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.TWO, Card.Suit.CLUB);
        addCardToVisiblePile(game.getBoard().getPiles()[4], Card.Value.SEVEN, Card.Suit.CLUB);

        game.getBoard().getPiles()[5] = new Pile();
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.FIVE, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.FOUR, Card.Suit.CLUB);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.QUEEN, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.JACK, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.KING, Card.Suit.HEART);
        addCardToVisiblePile(game.getBoard().getPiles()[5], Card.Value.TWO, Card.Suit.SPADE);

        game.getBoard().getPiles()[6] = new Pile();
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.TWO, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[6],Card.Value.EIGHT, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.NINE, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.EIGHT, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.EIGHT, Card.Suit.CLUB);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.KING, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[6], Card.Value.AS, Card.Suit.SPADE);

        //VALIDATED
        return game;
    }

    public static Game specialRedraw() {
        Game game = new Game();

        //DECK
        addCardToDeck(game.getBoard().getDeck(), Card.Value.AS, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.TEN, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.NINE, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FIVE, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.THREE, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.JACK, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FOUR, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.AS, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FOUR, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.TWO, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.SEVEN, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.SEVEN, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.THREE, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.EIGHT, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.TEN, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.THREE, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.AS, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.SIX, Card.Suit.DIAMOND);

        addCardToDrawnCards(game.getBoard().getDeck(), Card.Value.KING, Card.Suit.CLUB);
        addCardToDrawnCards(game.getBoard().getDeck(), Card.Value.FIVE, Card.Suit.CLUB);
        addCardToDrawnCards(game.getBoard().getDeck(), Card.Value.NINE, Card.Suit.CLUB);

        addCardToAlreadySeen(game.getBoard().getDeck(), Card.Value.SIX, Card.Suit.CLUB);
        addCardToAlreadySeen(game.getBoard().getDeck(), Card.Value.QUEEN, Card.Suit.HEART);


        //PILES
        game.getBoard().getPiles()[0] = new Pile();
        addCardToVisiblePile(game.getBoard().getPiles()[0], Card.Value.SIX, Card.Suit.HEART);
        addCardToVisiblePile(game.getBoard().getPiles()[0], Card.Value.FIVE, Card.Suit.SPADE);

        game.getBoard().getPiles()[1] = new Pile();
        addCardToPile(game.getBoard().getPiles()[1], Card.Value.THREE, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[1], Card.Value.SIX, Card.Suit.SPADE);

        game.getBoard().getPiles()[2] = new Pile();
        addCardToPile(game.getBoard().getPiles()[2], Card.Value.TEN, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[2], Card.Value.QUEEN, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[2], Card.Value.SEVEN, Card.Suit.SPADE);

        game.getBoard().getPiles()[3] = new Pile();
        addCardToPile(game.getBoard().getPiles()[3], Card.Value.FOUR, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[3], Card.Value.QUEEN, Card.Suit.CLUB);
        addCardToPile(game.getBoard().getPiles()[3],Card.Value.JACK, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[3], Card.Value.NINE, Card.Suit.DIAMOND);

        game.getBoard().getPiles()[4] = new Pile();
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.TEN, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.KING, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.JACK, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.TWO, Card.Suit.CLUB);
        addCardToVisiblePile(game.getBoard().getPiles()[4], Card.Value.SEVEN, Card.Suit.CLUB);

        game.getBoard().getPiles()[5] = new Pile();
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.FIVE, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.FOUR, Card.Suit.CLUB);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.QUEEN, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.JACK, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.KING, Card.Suit.HEART);
        addCardToVisiblePile(game.getBoard().getPiles()[5], Card.Value.TWO, Card.Suit.SPADE);

        game.getBoard().getPiles()[6] = new Pile();
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.TWO, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[6],Card.Value.EIGHT, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.NINE, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.EIGHT, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.EIGHT, Card.Suit.CLUB);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.KING, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[6], Card.Value.AS, Card.Suit.SPADE);

        //VALIDATED

        return game;
    }

    public static Game init3() {
        Game game = new Game();

        //DECK
        addCardToDeck(game.getBoard().getDeck(), Card.Value.AS, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.TEN, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.NINE, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FIVE, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.THREE, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.JACK, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FOUR, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.AS, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FOUR, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.TWO, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.SEVEN, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.SEVEN, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.THREE, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.EIGHT, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.TEN, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.THREE, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.AS, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.SIX, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.NINE, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FIVE, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.KING, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FIVE, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.QUEEN, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.SIX, Card.Suit.CLUB);


        //PILES
        game.getBoard().getPiles()[0] = new Pile();
        addCardToVisiblePile(game.getBoard().getPiles()[0], Card.Value.SIX, Card.Suit.HEART);

        game.getBoard().getPiles()[1] = new Pile();
        addCardToPile(game.getBoard().getPiles()[1], Card.Value.THREE, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[1], Card.Value.SIX, Card.Suit.DIAMOND);

        game.getBoard().getPiles()[2] = new Pile();
        addCardToPile(game.getBoard().getPiles()[2], Card.Value.TEN, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[2], Card.Value.QUEEN, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[2], Card.Value.SEVEN, Card.Suit.SPADE);

        game.getBoard().getPiles()[3] = new Pile();
        addCardToPile(game.getBoard().getPiles()[3], Card.Value.FOUR, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[3], Card.Value.QUEEN, Card.Suit.CLUB);
        addCardToPile(game.getBoard().getPiles()[3],Card.Value.JACK, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[3], Card.Value.NINE, Card.Suit.DIAMOND);

        game.getBoard().getPiles()[4] = new Pile();
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.TEN, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.KING, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.JACK, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.TWO, Card.Suit.CLUB);
        addCardToVisiblePile(game.getBoard().getPiles()[4], Card.Value.SEVEN, Card.Suit.CLUB);

        game.getBoard().getPiles()[5] = new Pile();
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.FIVE, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.FOUR, Card.Suit.CLUB);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.QUEEN, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.JACK, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.KING, Card.Suit.HEART);
        addCardToVisiblePile(game.getBoard().getPiles()[5], Card.Value.TWO, Card.Suit.SPADE);

        game.getBoard().getPiles()[6] = new Pile();
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.TWO, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[6],Card.Value.EIGHT, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.NINE, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.EIGHT, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.EIGHT, Card.Suit.CLUB);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.KING, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[6], Card.Value.AS, Card.Suit.SPADE);

        //VALIDATED

        return game;
    }

    public static Game gameWithACardFromPileToPile() {
        Game game = new Game();

        //DECK
        addCardToDeck(game.getBoard().getDeck(), Card.Value.AS, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.TEN, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.NINE, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FIVE, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.THREE, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.JACK, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FOUR, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.AS, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FOUR, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.TWO, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.SEVEN, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.SEVEN, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.THREE, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.EIGHT, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.TEN, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.THREE, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.AS, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.SIX, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.NINE, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FIVE, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.KING, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FIVE, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.QUEEN, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.SIX, Card.Suit.CLUB);


        //PILES
        game.getBoard().getPiles()[0] = new Pile();
        addCardToVisiblePile(game.getBoard().getPiles()[0], Card.Value.SIX, Card.Suit.HEART);

        game.getBoard().getPiles()[1] = new Pile();
        addCardToVisiblePile(game.getBoard().getPiles()[1], Card.Value.THREE, Card.Suit.SPADE);

        game.getBoard().getPiles()[2] = new Pile();
        addCardToPile(game.getBoard().getPiles()[2], Card.Value.TEN, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[2], Card.Value.QUEEN, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[2], Card.Value.SEVEN, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[2], Card.Value.SIX, Card.Suit.DIAMOND);

        game.getBoard().getPiles()[3] = new Pile();
        addCardToPile(game.getBoard().getPiles()[3], Card.Value.FOUR, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[3], Card.Value.QUEEN, Card.Suit.CLUB);
        addCardToPile(game.getBoard().getPiles()[3],Card.Value.JACK, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[3], Card.Value.NINE, Card.Suit.DIAMOND);

        game.getBoard().getPiles()[4] = new Pile();
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.TEN, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.KING, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.JACK, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.TWO, Card.Suit.CLUB);
        addCardToVisiblePile(game.getBoard().getPiles()[4], Card.Value.SEVEN, Card.Suit.CLUB);

        game.getBoard().getPiles()[5] = new Pile();
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.FIVE, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.FOUR, Card.Suit.CLUB);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.QUEEN, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.JACK, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.KING, Card.Suit.HEART);
        addCardToVisiblePile(game.getBoard().getPiles()[5], Card.Value.TWO, Card.Suit.SPADE);

        game.getBoard().getPiles()[6] = new Pile();
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.TWO, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[6],Card.Value.EIGHT, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.NINE, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.EIGHT, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.EIGHT, Card.Suit.CLUB);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.KING, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[6], Card.Value.AS, Card.Suit.SPADE);

        //VALIDATED

        return game;
    }

    public static Game init4() {
        Game game = new Game();

        //DECK
        addCardToDeck(game.getBoard().getDeck(), Card.Value.AS, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.TEN, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.NINE, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FIVE, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.THREE, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.JACK, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FOUR, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.AS, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FOUR, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.TWO, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.SEVEN, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.SEVEN, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.THREE, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.EIGHT, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.TEN, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.THREE, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.AS, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.SIX, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.NINE, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FIVE, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.KING, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FIVE, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.QUEEN, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.SIX, Card.Suit.CLUB);


        //PILES
        game.getBoard().getPiles()[0] = new Pile();

        game.getBoard().getPiles()[1] = new Pile();
        addCardToPile(game.getBoard().getPiles()[1], Card.Value.THREE, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[1], Card.Value.SIX, Card.Suit.DIAMOND);

        game.getBoard().getPiles()[2] = new Pile();
        addCardToPile(game.getBoard().getPiles()[2], Card.Value.TEN, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[2], Card.Value.QUEEN, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[2], Card.Value.SEVEN, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[2], Card.Value.SIX, Card.Suit.HEART);

        game.getBoard().getPiles()[3] = new Pile();
        addCardToPile(game.getBoard().getPiles()[3], Card.Value.FOUR, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[3], Card.Value.QUEEN, Card.Suit.CLUB);
        addCardToPile(game.getBoard().getPiles()[3],Card.Value.JACK, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[3], Card.Value.NINE, Card.Suit.DIAMOND);

        game.getBoard().getPiles()[4] = new Pile();
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.TEN, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.KING, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.JACK, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.TWO, Card.Suit.CLUB);
        addCardToVisiblePile(game.getBoard().getPiles()[4], Card.Value.SEVEN, Card.Suit.CLUB);

        game.getBoard().getPiles()[5] = new Pile();
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.FIVE, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.FOUR, Card.Suit.CLUB);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.QUEEN, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.JACK, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.KING, Card.Suit.HEART);
        addCardToVisiblePile(game.getBoard().getPiles()[5], Card.Value.TWO, Card.Suit.SPADE);

        game.getBoard().getPiles()[6] = new Pile();
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.TWO, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[6],Card.Value.EIGHT, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.NINE, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.AS, Card.Suit.SPADE);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.EIGHT, Card.Suit.CLUB);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.KING, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[6], Card.Value.EIGHT, Card.Suit.DIAMOND);

        //VALIDATED

        return game;
    }

    public static Game severalCardsFromPileToPile() {
        Game game = new Game();

        //DECK
        addCardToDeck(game.getBoard().getDeck(), Card.Value.AS, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.TEN, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.NINE, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FIVE, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.THREE, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.JACK, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FOUR, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.AS, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FOUR, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.TWO, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.SEVEN, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.SEVEN, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.THREE, Card.Suit.DIAMOND);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.EIGHT, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.TEN, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.THREE, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.AS, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.SIX, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.NINE, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FIVE, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.KING, Card.Suit.CLUB);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.FIVE, Card.Suit.SPADE);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.QUEEN, Card.Suit.HEART);
        addCardToDeck(game.getBoard().getDeck(), Card.Value.SIX, Card.Suit.CLUB);


        //PILES
        game.getBoard().getPiles()[0] = new Pile();

        game.getBoard().getPiles()[1] = new Pile();
        addCardToPile(game.getBoard().getPiles()[1], Card.Value.THREE, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[1], Card.Value.SIX, Card.Suit.DIAMOND);

        game.getBoard().getPiles()[2] = new Pile();
        addCardToPile(game.getBoard().getPiles()[2], Card.Value.TEN, Card.Suit.DIAMOND);
        addCardToVisiblePile(game.getBoard().getPiles()[2], Card.Value.QUEEN, Card.Suit.SPADE);

        game.getBoard().getPiles()[3] = new Pile();
        addCardToPile(game.getBoard().getPiles()[3], Card.Value.FOUR, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[3], Card.Value.QUEEN, Card.Suit.CLUB);
        addCardToPile(game.getBoard().getPiles()[3],Card.Value.JACK, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[3], Card.Value.NINE, Card.Suit.DIAMOND);

        game.getBoard().getPiles()[4] = new Pile();
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.TEN, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.KING, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.JACK, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[4], Card.Value.TWO, Card.Suit.CLUB);
        addCardToVisiblePile(game.getBoard().getPiles()[4], Card.Value.SEVEN, Card.Suit.CLUB);

        game.getBoard().getPiles()[5] = new Pile();
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.FIVE, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.FOUR, Card.Suit.CLUB);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.QUEEN, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.JACK, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[5], Card.Value.KING, Card.Suit.HEART);
        addCardToVisiblePile(game.getBoard().getPiles()[5], Card.Value.TWO, Card.Suit.SPADE);

        game.getBoard().getPiles()[6] = new Pile();
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.TWO, Card.Suit.DIAMOND);
        addCardToPile(game.getBoard().getPiles()[6],Card.Value.EIGHT, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.NINE, Card.Suit.HEART);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.AS, Card.Suit.SPADE);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.EIGHT, Card.Suit.CLUB);
        addCardToPile(game.getBoard().getPiles()[6], Card.Value.KING, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[6], Card.Value.EIGHT, Card.Suit.DIAMOND);
        addCardToVisiblePile(game.getBoard().getPiles()[6], Card.Value.SEVEN, Card.Suit.SPADE);
        addCardToVisiblePile(game.getBoard().getPiles()[6], Card.Value.SIX, Card.Suit.HEART);

        //VALIDATED

        return game;
    }

    private static void addCardToDeck(Deck deck, Card.Value value, Card.Suit suit) {
        Card card = new Card(value, suit);
        deck.addCard(card);
    }

    private static void addCardToDrawnCards(Deck deck, Card.Value value, Card.Suit suit) {
        Card card = new Card(value, suit);
        deck.addCardToDrawnCards(card);
    }

    private static void addCardToAlreadySeen(Deck deck, Card.Value value, Card.Suit suit) {
        Card card = new Card(value, suit);
        deck.addCardToAlreadySeen(card);
    }

    private static void addCardToPile(Pile pile, Card.Value value, Card.Suit suit) {
        Card card = new Card(value, suit);
        pile.addCard(card);
    }

    private static void addCardToVisiblePile(Pile pile, Card.Value value, Card.Suit suit) {
        Card card = new Card(value, suit);
        pile.addVisibleCard(card);
    }

    private static void addCardToValidated(Pile pile, Card.Value value, Card.Suit suit) {
        Card card = new Card(value, suit);
        pile.addCard(card);
    }
}
