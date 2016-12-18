package ie.slegras.solitaire.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceView;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

import ie.slegras.solitaire.R;
import ie.slegras.solitaire.model.Card;
import ie.slegras.solitaire.model.Deck;
import ie.slegras.solitaire.model.Game;
import ie.slegras.solitaire.model.Pile;

import static ie.slegras.solitaire.R.drawable.back;

/**
 * Created by Sophie on 24/10/2016.
 */

public class Panel extends SurfaceView {
    private Linker linker;
    public Paint paint;
    private ArtificialIntelligence artificialIntelligence;
    private ArrayList<Bitmap> bitmaps = new ArrayList<>();
    private Bitmap missing;
    private Bitmap lost;
    private Bitmap newGame;
    private Bitmap wonGame;
    private Matrix positionSpade;
    private Matrix positionDiamond;
    private Matrix positionClub;
    private Matrix positionHeart;
    private Matrix positionSeen1;
    private Matrix positionSeen2;
    private Matrix positionSeen3;
    private Matrix positionDeck;
    private Matrix positionPile1;
    private Matrix positionPile2;
    private Matrix positionPile3;
    private Matrix positionPile4;
    private Matrix positionPile5;
    private Matrix positionPile6;
    private Matrix positionPile7;
    private Matrix positionNew;
    private Matrix positionTextGameLost;
    private float width;
    private float height;
    private Game game;
    private Matrix currentMovingPosition;
    private Card currentMovingCard;
    private Deque<Card> cardsUnder;

    private float xMinNew;
    private float yMinNew;
    private float xMinDeck;
    private float xMaxDeck;
    private float yMinDeck;
    private float yMaxDeck;
    private float xMinDrawnDeck;
    private float xMaxDrawnDeck;
    private float yMinDrawnDeck;
    private float yMaxDrawnDeck;
    private float xMinValidated;
    private float xMaxValidated;
    private float yMinValidated;
    private float yMaxValidated;
    private ArrayList<Float> xMinPile;
    private ArrayList<Float> xMaxPile;
    private ArrayList<Float> yMinPile;
    private ArrayList<Float> yMaxPile;
    private ArrayList<ArrayList<Card>> cardVisible = new ArrayList<>();

    public Panel(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
        setFocusable(true);
        paint = new Paint();
        linker = new Linker();
        artificialIntelligence = new ArtificialIntelligence();
        loadBitmaps();
    }

    public float getRealHeight() {
        return height;
    }

    public float getRealWidth() {
        return width;
    }

    private void loadBitmaps() {
        bitmaps.add(BitmapFactory.decodeResource(getResources(), back));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.spades1));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.spades2));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.spades3));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.spades4));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.spades5));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.spades6));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.spades7));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.spades8));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.spades9));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.spades10));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.spades11));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.spades12));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.spades13));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.hearts1));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.hearts2));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.hearts3));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.hearts4));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.hearts5));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.hearts6));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.hearts7));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.hearts8));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.hearts9));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.hearts10));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.hearts11));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.hearts12));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.hearts13));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.diamonds1));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.diamonds2));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.diamonds3));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.diamonds4));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.diamonds5));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.diamonds6));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.diamonds7));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.diamonds8));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.diamonds9));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.diamonds10));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.diamonds11));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.diamonds12));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.diamonds13));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.clubs1));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.clubs2));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.clubs3));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.clubs4));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.clubs5));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.clubs6));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.clubs7));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.clubs8));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.clubs9));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.clubs10));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.clubs11));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.clubs12));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.clubs13));
        missing = BitmapFactory.decodeResource(getResources(), R.drawable.green2);
        lost = BitmapFactory.decodeResource(getResources(), R.drawable.lost);
        newGame = BitmapFactory.decodeResource(getResources(), R.drawable.newgame);
        wonGame = BitmapFactory.decodeResource(getResources(), R.drawable.won);
    }

    private void initializePositions(float unityBase) {
        positionSpade = new Matrix();
        positionDiamond = new Matrix();
        positionClub = new Matrix();
        positionHeart = new Matrix();
        positionSeen1 = new Matrix();
        positionSeen2 = new Matrix();
        positionSeen3 = new Matrix();
        positionDeck = new Matrix();
        positionPile1 = new Matrix();
        positionPile2 = new Matrix();
        positionPile3 = new Matrix();
        positionPile4 = new Matrix();
        positionPile5 = new Matrix();
        positionPile6 = new Matrix();
        positionPile7 = new Matrix();
        positionTextGameLost = new Matrix();
        positionNew = new Matrix();

        float unityStep = 1.3f * width / 10.0f;
        float unityMin = width / 30.0f;

        Matrix tmp = new Matrix();
        tmp.postScale(unityBase, unityBase);
        tmp.postTranslate(unityMin, 2 * unityMin);
        positionSpade.set(tmp);

        tmp.postTranslate(unityStep, 0);
        positionDiamond.set(tmp);

        tmp.postTranslate(unityStep, 0);
        positionClub.set(tmp);

        tmp.postTranslate(unityStep, 0);
        positionHeart.set(tmp);

        tmp.postTranslate(1.75f * unityStep, 0);
        positionSeen1.set(tmp);

        tmp.postTranslate(unityMin, 0);
        positionSeen2.set(tmp);

        tmp.postTranslate(unityMin, 0);
        positionSeen3.set(tmp);

        tmp.postTranslate(unityStep, 0);
        positionDeck.set(tmp);

        tmp = new Matrix();
        tmp.postScale(unityBase, unityBase);
        tmp.postTranslate(unityMin, 3.5f * unityStep);
        positionPile1.set(tmp);

        tmp.postTranslate(unityStep, 0);
        positionPile2.set(tmp);
        tmp.postTranslate(unityStep, 0);
        positionPile3.set(tmp);
        tmp.postTranslate(unityStep, 0);
        positionPile4.set(tmp);
        tmp.postTranslate(unityStep, 0);
        positionPile5.set(tmp);
        tmp.postTranslate(unityStep, 0);
        positionPile6.set(tmp);
        tmp.postTranslate(unityStep, 0);
        positionPile7.set(tmp);

        initPositionForListener(unityMin, unityStep, unityBase);

        tmp = new Matrix();
        float scale = height / (8.0f * lost.getHeight());
        tmp.postScale(scale, scale);
        tmp.postTranslate(width / 2.0f - lost.getWidth() * scale / 2.0f, height - height / 4.0f);
        positionTextGameLost.set(tmp);

        tmp = new Matrix();
        scale = height / (12.0f * newGame.getHeight());
        tmp.postScale(scale, scale);
        tmp.postTranslate(width - height / 8.0f, height - height / 8.0f);
        positionNew.set(tmp);
    }

    private void initPositionForListener(float unityMin, float unityStep, float unityBase) {
        xMinDeck = unityMin + 3.0f * unityStep + 1.75f * unityStep + 2.0f * unityMin + unityStep;
        xMaxDeck = xMinDeck + unityStep;
        yMinDeck = 2 * unityMin;
        yMaxDeck = yMinDeck + bitmaps.get(0).getHeight();

        xMinDrawnDeck = unityMin + 3.0f * unityStep + 1.75f * unityStep;
        xMaxDrawnDeck = xMaxDrawnDeck + 2.0f * unityMin;
        yMinDrawnDeck = yMinDeck;
        yMaxDrawnDeck = yMaxDeck;

        xMinValidated = unityMin;
        xMaxValidated = xMinValidated + 4 * unityStep;
        yMinValidated = yMinDeck;
        yMaxValidated = yMaxDeck;

        xMinPile = new ArrayList<>();
        xMaxPile = new ArrayList<>();
        yMinPile = new ArrayList<>();
        yMaxPile = new ArrayList<>();

        xMinPile.add(unityMin);
        xMaxPile.add(unityMin + unityStep);
        yMinPile.add(5.1f * unityStep);
        yMaxPile.add(5.1f * unityStep + bitmaps.get(0).getHeight() * unityBase);

        xMinPile.add(unityMin + unityStep);
        xMaxPile.add(unityMin + 2 *unityStep);
        yMinPile.add(5.1f * unityStep);
        yMaxPile.add(5.1f * unityStep + bitmaps.get(0).getHeight() * unityBase);

        xMinPile.add(unityMin + 2 * unityStep);
        xMaxPile.add(unityMin + 3 *unityStep);
        yMinPile.add(5.1f * unityStep);
        yMaxPile.add(5.1f * unityStep + bitmaps.get(0).getHeight() * unityBase);

        xMinPile.add(unityMin + 3 * unityStep);
        xMaxPile.add(unityMin + 4 *unityStep);
        yMinPile.add(5.1f * unityStep);
        yMaxPile.add(5.1f * unityStep + bitmaps.get(0).getHeight() * unityBase);

        xMinPile.add(unityMin + 4 * unityStep);
        xMaxPile.add(unityMin + 5 *unityStep);
        yMinPile.add(5.1f * unityStep);
        yMaxPile.add(5.1f * unityStep + bitmaps.get(0).getHeight() * unityBase);

        xMinPile.add(unityMin + 5 * unityStep);
        xMaxPile.add(unityMin + 6 *unityStep);
        yMinPile.add(5.1f * unityStep);
        yMaxPile.add(5.1f * unityStep + bitmaps.get(0).getHeight() * unityBase);

        xMinPile.add(unityMin + 6 * unityStep);
        xMaxPile.add(unityMin + 7 *unityStep);
        yMinPile.add(5.1f * unityStep);
        yMaxPile.add(5.1f * unityStep + bitmaps.get(0).getHeight() * unityBase);

        xMinNew = width - height / 8.0f;
        yMinNew = height - height / 8.0f;
    }

    @Override
    //Works like screen refreshing
    public void onDraw(Canvas canvas) {
        width = canvas.getWidth();
        height = canvas.getHeight();
        float unityBase = (1.0f / 9.0f * width) / bitmaps.get(1).getWidth();

        initializePositions(unityBase);

        displayCards(canvas);

        if (artificialIntelligence.lookIfGameLost(game)) {
            canvas.drawBitmap(lost, positionTextGameLost, null);
        } else if(artificialIntelligence.lookIfGameWon(game)) {
            canvas.drawBitmap(wonGame, positionTextGameLost, null);
        }
        canvas.drawBitmap(newGame, positionNew, null);
    }

    private void displayCards(Canvas canvas) {
        canvas.drawColor(getResources().getColor(R.color.colorPrimary));

        //UP
        Pile[] validatedCards = game.getBoard().getValidatedCards();
        drawPositionForValidated(canvas, validatedCards, positionSpade, 0);
        drawPositionForValidated(canvas, validatedCards, positionHeart, 1);
        drawPositionForValidated(canvas, validatedCards, positionDiamond, 2);
        drawPositionForValidated(canvas, validatedCards, positionClub, 3);

        Deck deck = game.getBoard().getDeck();
        Deque<Card> drawn = deck.getDrawnCards();
        drawPositionForSeen(canvas, drawn);

        if (deck.getUnseen().size() > 0) {
            canvas.drawBitmap(bitmaps.get(0), positionDeck, null);
        } else {
            canvas.drawBitmap(missing, positionDeck, null);
        }

        //DOWN
        Pile[] piles = game.getBoard().getPiles();
        drawPositionForPiles(canvas, piles, positionPile1, 0);
        drawPositionForPiles(canvas, piles, positionPile2, 1);
        drawPositionForPiles(canvas, piles, positionPile3, 2);
        drawPositionForPiles(canvas, piles, positionPile4, 3);
        drawPositionForPiles(canvas, piles, positionPile5, 4);
        drawPositionForPiles(canvas, piles, positionPile6, 5);
        drawPositionForPiles(canvas, piles, positionPile7, 6);

        //MOVING
        if (currentMovingPosition != null) {
            float unityMin = width / 30.0f;
            if (cardsUnder != null && cardsUnder.size() > 0) {
                Deque<Card> saveStateCards = new ArrayDeque<>();
                while(cardsUnder.size() > 0) {
                    Card current = cardsUnder.pop();
                    currentMovingPosition.postTranslate(0, 2 * unityMin);
                    int bitmapPosition = (current.getSuit().ordinal() * 13) + current.getValue().ordinal() + 1;
                    canvas.drawBitmap(bitmaps.get(bitmapPosition), currentMovingPosition, null);
                    saveStateCards.push(current);
                }
                while(saveStateCards.size() > 0) {
                    Card card = saveStateCards.pop();
                    cardsUnder.push(card);
                }
            } else {
                int bitmapPosition = (currentMovingCard.getSuit().ordinal() * 13) + currentMovingCard.getValue().ordinal() + 1;
                canvas.drawBitmap(bitmaps.get(bitmapPosition), currentMovingPosition, null);
            }
        }
    }

    private void drawPositionForValidated(Canvas canvas, Pile[] validatedCards, Matrix position, int index) {
        if (validatedCards.length > index && validatedCards[index] != null && validatedCards[index].getCards().size() > 0) {
            Card card = validatedCards[index].getCards().peek();
            if (card == currentMovingCard) {
                return;
            }
            int bitmapPosition = (card.getSuit().ordinal() * 13) + card.getValue().ordinal() + 1;
            canvas.drawBitmap(bitmaps.get(bitmapPosition), position, null);
        } else {
            canvas.drawBitmap(missing, position, null);
        }
    }

    private void drawPositionForSeen(Canvas canvas, Deque<Card> drawn) {
        if (drawn.size() > 2) {
            canvas.drawBitmap(bitmaps.get(0), positionSeen3, null);
        }
        if (drawn.size() > 1) {
            canvas.drawBitmap(bitmaps.get(0), positionSeen2, null);
        }
        if (drawn.size() > 0) {
            Card card = drawn.peek();
            if (card == currentMovingCard) {
                return;
            }
            int bitmapPosition = (card.getSuit().ordinal() * 13) + card.getValue().ordinal() + 1;
            canvas.drawBitmap(bitmaps.get(bitmapPosition), positionSeen1, null);
        }
    }

    private void drawPositionForPiles(Canvas canvas, Pile[] piles, Matrix position, int index) {
        if (piles.length > index && piles[index] != null && piles[index].getVisibleCards().size() > 0) {
            int size = piles[index].getCards().size();
            while (size > 0) {
                canvas.drawBitmap(bitmaps.get(0), position, null);
                float unityMin = width / 30.0f;
                position.postTranslate(0, unityMin);
                yMaxPile.set(index, yMaxPile.get(index) + unityMin);
                size--;
            }
            size = piles[index].getVisibleCards().size();
            ArrayDeque<Card> inverse = new ArrayDeque<>();
            Deque<Card> underThisCard = piles[index].getCardsUnderThisOne(currentMovingCard);
            while (size > 0) {
                Card card = piles[index].getVisibleCards().pop();
                if (underThisCard != null && underThisCard.contains(card)) {
                    size--;
                    continue;
                }
                inverse.push(card);
                size--;
            }
            cardVisible.add(new ArrayList<Card>());
            while(inverse.size() > 0) {
                Card card = inverse.pop();
                int bitmapPosition = (card.getSuit().ordinal() * 13) + card.getValue().ordinal() + 1;
                canvas.drawBitmap(bitmaps.get(bitmapPosition), position, null);
                float unityMin = width / 30.0f;
                yMaxPile.set(index, yMaxPile.get(index) + 2 * unityMin);
                position.postTranslate(0, 2 * unityMin);

                cardVisible.get(index).add(card);
                piles[index].getVisibleCards().push(card);
            }
            if (underThisCard != null) {
                while(underThisCard.size() > 0) {
                    Card current = underThisCard.pop();
                    piles[index].getVisibleCards().push(current);
                }
            }
        } else {
            canvas.drawBitmap(missing, position, null);
        }
    }

    private void updateVisibleCards() {
        Pile [] piles = game.getBoard().getPiles();
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] != null && piles[i].getVisibleCards().size() > 0) {
                int size = piles[i].getVisibleCards().size();
                ArrayDeque<Card> inverse = new ArrayDeque<>();
                Deque<Card> underThisCard = piles[i].getCardsUnderThisOne(currentMovingCard);
                while (size > 0) {
                    Card card = piles[i].getVisibleCards().pop();
                    if (underThisCard != null && underThisCard.contains(card)) {
                        size--;
                        continue;
                    }
                    inverse.push(card);
                    size--;
                }
                cardVisible.add(new ArrayList<Card>());
                while(inverse.size() > 0) {
                    Card card = inverse.pop();
                    cardVisible.get(i).add(card);
                    piles[i].getVisibleCards().push(card);
                }
                if (underThisCard != null) {
                    while(underThisCard.size() > 0) {
                        Card current = underThisCard.pop();
                        piles[i].getVisibleCards().push(current);
                    }
                }
            }
        }
    }

    public void receiveTouchEvent(float x, float y) {
        updateVisibleCards();
        float unity = 2 * width / 30.0f;
        if (x > xMinDeck && x < xMaxDeck && y < yMaxDeck && y > yMinDeck) {
            game = linker.deckAction(game);
        } else if (x > xMinDrawnDeck && x < xMaxDrawnDeck && y < yMaxDrawnDeck && y > yMinDrawnDeck) {
            if (game.getBoard().getDeck().getDrawnCards().size() > 0) {
                currentMovingPosition = positionSeen1;
                currentMovingCard = game.getBoard().getDeck().getDrawnCards().peek();
                Log.e("CARD", "1 " + currentMovingCard);
                Log.e("CARD", "1 " + game.getBoard().getDeck().getDrawnCards());
            }
        } else if (x > xMinPile.get(0) && x < xMaxPile.get(0) && y < yMaxPile.get(0) && y > yMinPile.get(0)) {
            for (int i = cardVisible.get(0).size() - 1; i >= 0; i--) {
                if (y < yMaxPile.get(0) - (cardVisible.get(0).size() - 1 - i) * unity
                        && y > yMaxPile.get(0) - (cardVisible.get(0).size() - i) * unity) {
                    currentMovingPosition = positionPile1;
                    currentMovingCard = cardVisible.get(0).get(i);
                    cardsUnder = game.getBoard().getPiles()[0].getCardsUnderThisOne(currentMovingCard);
                    Log.e("CARD", "2 " + currentMovingCard);
                    Log.e("CARD", "2 " + cardVisible.get(0).get(i));
                    Log.e("CARD", "2 " + game.getBoard().getPiles()[0].getVisibleCards().peek());
                    break;
                }
            }
        } else if (x > xMinPile.get(1) && x < xMaxPile.get(1) && y < yMaxPile.get(1) && y > yMinPile.get(1)) {
            for (int i = cardVisible.get(1).size() - 1; i >= 0; i--) {
                if (y < yMaxPile.get(1) - (cardVisible.get(1).size() - 1 - i) * unity
                        && y > yMaxPile.get(1) - (cardVisible.get(1).size() - i) * unity) {
                    currentMovingPosition = positionPile2;
                    currentMovingCard = cardVisible.get(1).get(i);
                    cardsUnder = game.getBoard().getPiles()[1].getCardsUnderThisOne(currentMovingCard);
                    Log.e("CARD", "3 " + currentMovingCard);
                    Log.e("CARD", "3 " + cardVisible.get(1).get(i));
                    break;
                }
            }
        } else if (x > xMinPile.get(2) && x < xMaxPile.get(2) && y < yMaxPile.get(2) && y > yMinPile.get(2)) {
            for (int i = cardVisible.get(2).size() - 1; i >= 0; i--) {
                if (y < yMaxPile.get(2) - (cardVisible.get(2).size() - 1 - i) * unity
                        && y > yMaxPile.get(2) - (cardVisible.get(2).size() - i) * unity) {
                    currentMovingPosition = positionPile3;
                    currentMovingCard = cardVisible.get(2).get(i);
                    cardsUnder = game.getBoard().getPiles()[2].getCardsUnderThisOne(currentMovingCard);
                    Log.e("CARD", "4 " + currentMovingCard);
                    Log.e("CARD", "4 " + cardVisible.get(2).get(i));
                    break;
                }
            }
        } else if (x > xMinPile.get(3) && x < xMaxPile.get(3) && y < yMaxPile.get(3) && y > yMinPile.get(3)) {
            for (int i = cardVisible.get(3).size() - 1; i >= 0; i--) {
                if (y < yMaxPile.get(3) - (cardVisible.get(3).size() - 1 - i) * unity
                        && y > yMaxPile.get(3) - (cardVisible.get(3).size() - i) * unity) {
                    currentMovingPosition = positionPile4;
                    currentMovingCard = cardVisible.get(3).get(i);
                    cardsUnder = game.getBoard().getPiles()[3].getCardsUnderThisOne(currentMovingCard);
                    Log.e("CARD", "5 " + currentMovingCard);
                    Log.e("CARD", "6 " + cardVisible.get(3).get(i));
                    break;
                }
            }
        } else if (x > xMinPile.get(4) && x < xMaxPile.get(4) && y < yMaxPile.get(4) && y > yMinPile.get(4)) {
            for (int i = cardVisible.get(4).size() - 1; i >= 0; i--) {
                if (y < yMaxPile.get(4) - (cardVisible.get(4).size() - 1 - i) * unity
                        && y > yMaxPile.get(4) - (cardVisible.get(4).size() - i) * unity) {
                    currentMovingPosition = positionPile5;
                    currentMovingCard = cardVisible.get(4).get(i);
                    cardsUnder = game.getBoard().getPiles()[4].getCardsUnderThisOne(currentMovingCard);
                    Log.e("CARD", "6 " + currentMovingCard);
                    Log.e("CARD", "6 " + cardVisible.get(4).get(i));
                    break;
                }
            }
        } else if (x > xMinPile.get(5) && x < xMaxPile.get(5) && y < yMaxPile.get(5) && y > yMinPile.get(5)) {
            for (int i = cardVisible.get(5).size() - 1; i >= 0; i--) {
                if (y < yMaxPile.get(5) - (cardVisible.get(5).size() - 1 - i) * unity
                        && y > yMaxPile.get(5) - (cardVisible.get(5).size() - i) * unity) {
                    currentMovingPosition = positionPile6;
                    currentMovingCard = cardVisible.get(5).get(i);
                    cardsUnder = game.getBoard().getPiles()[5].getCardsUnderThisOne(currentMovingCard);
                    Log.e("CARD", "7 " + currentMovingCard);
                    Log.e("CARD", "7 " + cardVisible.get(5).get(i));
                    break;
                }
            }
        } else if (x > xMinPile.get(6) && x < xMaxPile.get(6) && y < yMaxPile.get(6) && y > yMinPile.get(6)) {
            for (int i = cardVisible.get(6).size() - 1; i >= 0; i--) {
                if (y < yMaxPile.get(6) - (cardVisible.get(6).size() - 1 - i) * unity
                        && y > yMaxPile.get(6) - (cardVisible.get(6).size() - i) * unity) {
                    currentMovingPosition = positionPile7;
                    currentMovingCard = cardVisible.get(6).get(i);
                    cardsUnder = game.getBoard().getPiles()[6].getCardsUnderThisOne(currentMovingCard);
                    Log.e("CARD", "8 " + currentMovingCard);
                    Log.e("CARD", "8 " + cardVisible.get(6).get(i));
                    break;
                }
            }
        }
        Log.e("CARD", "Current moving card " + currentMovingCard);
    }

    public void receiveMovingEvent(float x, float y) {
        if (currentMovingPosition != null) {
            currentMovingPosition.reset();
            float widthStep = 1.3f * width / 10.0f;
            x = x - widthStep / 2.0f;
            y = y - widthStep;
            float unityBase = (1.0f / 9.0f * width) / bitmaps.get(1).getWidth();
            currentMovingPosition.postScale(unityBase, unityBase);
            currentMovingPosition.postScale(1.4f, 1.4f);
            currentMovingPosition.postTranslate(x, y);
        }
    }

    public void receiveStopEvent(float x, float y) {
        if (currentMovingCard != null) {
            if(x > xMinValidated && x < xMaxValidated && y < yMaxValidated && y > yMinValidated) {
                if (currentMovingCard.getSuit() == Card.Suit.SPADE) {
                    game = linker.spadeAction(game, currentMovingCard);
                } else if (currentMovingCard.getSuit() == Card.Suit.DIAMOND) {
                    game = linker.diamondAction(game, currentMovingCard);
                } else if (currentMovingCard.getSuit() == Card.Suit.CLUB) {
                    game = linker.clubAction(game, currentMovingCard);
                } else if (currentMovingCard.getSuit() == Card.Suit.HEART) {
                    game = linker.heartAction(game, currentMovingCard);
                }
            } else if (x > xMinPile.get(0) && x < xMaxPile.get(0) && y < yMaxPile.get(0) && y > yMinPile.get(0)) {
                game = linker.pileAction(game, currentMovingCard, 0);
            } else if (x > xMinPile.get(1) && x < xMaxPile.get(1) && y < yMaxPile.get(1) && y > yMinPile.get(1)) {
                game = linker.pileAction(game, currentMovingCard, 1);
            } else if (x > xMinPile.get(2) && x < xMaxPile.get(2) && y < yMaxPile.get(2) && y > yMinPile.get(2)) {
                game = linker.pileAction(game, currentMovingCard, 2);
            } else if (x > xMinPile.get(3) && x < xMaxPile.get(3) && y < yMaxPile.get(3) && y > yMinPile.get(3)) {
                game = linker.pileAction(game, currentMovingCard, 3);
            } else if (x > xMinPile.get(4) && x < xMaxPile.get(4) && y < yMaxPile.get(4) && y > yMinPile.get(4)) {
                game = linker.pileAction(game, currentMovingCard, 4);
            } else if (x > xMinPile.get(5) && x < xMaxPile.get(5) && y < yMaxPile.get(5) && y > yMinPile.get(5)) {
                game = linker.pileAction(game, currentMovingCard, 5);
            } else if (x > xMinPile.get(6) && x < xMaxPile.get(6) && y < yMaxPile.get(6) && y > yMinPile.get(6)) {
                game = linker.pileAction(game, currentMovingCard, 6);
            }
        }
        currentMovingCard = null;
        currentMovingPosition = null;
        cardsUnder = null;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Game getGame() { return game; }
}
