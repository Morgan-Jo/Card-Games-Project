package PokerGame;

import java.util.*;

public class Player {
 private final String name;
 private final List<Card> hand = new ArrayList<>();

 public Player(String name) {
     this.name = name;
 }

 public void drawCard(Card card) {
     hand.add(card);
 }

 public void discardAndDraw(Deck deck) {
     // Discard 0–3 cards at random (simplified)
     Random rand = new Random();
     int discards = rand.nextInt(4);
     for (int i = 0; i < discards; i++) {
         if (!hand.isEmpty()) {
             hand.remove(rand.nextInt(hand.size()));
             hand.add(deck.dealCard());
         }
     }
 }

 public List<Card> getHand() {
     return hand;
 }

 public String getName() {
     return name;
 }

 public String toString() {
     return name + "'s hand: " + hand;
 }
}
