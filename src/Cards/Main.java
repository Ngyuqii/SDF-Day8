package Cards;

import java.io.Console;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
     
     Deck deck = new Deck();
     System.out.println(deck); //print the cards in created deck

     deck.shuffle();
     System.out.println(deck); //print the cards in shuffled deck
     
     //Get an input from user
     Console cons = System.console();
     String input =  cons.readLine("How many cards would you like to take.");
     Integer numTake = Integer.parseInt(input);

     //Take cards from main deck and put in userDeck
     List<Card> userDeck = new LinkedList<>();
     for(Integer i=0; i < numTake; i++) {
     Card c = deck.take();
     userDeck.add(c);
     }
     System.out.println("You have a deck of " + userDeck);
     System.out.println("The main deck is now left with " + deck); //print the remaining cards in deck

     }

}