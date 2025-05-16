package PokerGame;

import java.util.*;

public class Deck {
 private final List<Card> cards = new ArrayList<>();

 public Deck() {
     String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
     String[] ranks = {
         "2", "3", "4", "5", "6", "7", "8", "9", "10",
         "Jack", "Queen", "King", "Ace"
     };

     for (String suit : suits) {
         for (int i = 0; i < ranks.length; i++) {
             cards.add(new Card(suit, ranks[i], i + 2));
         }
     }
 }

 public void shuffle() {
     Collections.shuffle(cards);
 }

 public Card dealCard() {
     return cards.remove(0);
 }
}
