package PokerGame;

import java.util.*;

@SuppressWarnings("unused")
public class PokerGame {

 public static void main(String[] args) {
     Deck deck = new Deck();
     deck.shuffle();

     Player player1 = new Player("Player 1");
     Player player2 = new Player("Player 2");

     // Deal 5 cards to each player
     for (int i = 0; i < 5; i++) {
         player1.drawCard(deck.dealCard());
         player2.drawCard(deck.dealCard());
     }

     System.out.println(player1);
     System.out.println(player2);

     // Simulate discard phase (random for demo purposes)
     player1.discardAndDraw(deck);
     player2.discardAndDraw(deck);

     System.out.println("\nAfter Draw:");
     System.out.println(player1);
     System.out.println(player2);

     // Compare hands
     int result = PokerHandEvaluator.compareHands(player1.getHand(), player2.getHand());

     System.out.println("\nResult:");
     if (result > 0) {
         System.out.println(player1.getName() + " wins!");
     } else if (result < 0) {
         System.out.println(player2.getName() + " wins!");
     } else {
         System.out.println("It's a tie!");
     }
 }
}

