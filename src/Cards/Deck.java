package Cards;

import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Deck {

    public static final String[] SUITS = { "Spade", "Diamond", "Clubs", "Heart" };
    public static final String[] CARD_NAME = { "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
     "Nine", "Ten", "Jack", "Queen", "King" };
    public static final Integer[] CARD_VALUE = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};

    private List<Card> deckofCards = new LinkedList<>();

    //Constructor
    public Deck() {
        this.deckofCards = createDeck();
    }

    //Method to create a deck
    private List<Card> createDeck() {
        for (String s: SUITS)
            for (Integer i = 0; i < CARD_NAME.length; i++) {
                Card card = new Card(s, CARD_NAME[i], CARD_VALUE[i]);
                deckofCards.add(card);
            }
        return deckofCards;
    }

    //Method to shuffle cards
    public List<Card> shuffle() {
        Random rnd = new SecureRandom();

        for (Integer i = 0; i < deckofCards.size(); i++) {
            Integer idx = rnd.nextInt(deckofCards.size());
            Card cardi = deckofCards.get(i);
            Card cardidx = deckofCards.get(idx);
            deckofCards.set(i, cardidx);
            deckofCards.set(idx, cardi);
        }
        return deckofCards;
    }

    public Card take() {
        if (deckofCards.size() > 0) {
            Card c = deckofCards.get(0); //takes first card of stack
            System.out.println("You have taken " + c);
            deckofCards.remove(0);
            return c;
        }
        else {
            System.out.println("There is no more card in the deck.");
            return null;
        }
        
    }

    @Override
    public String toString() {
        return "Deck" + deckofCards;
    }

}