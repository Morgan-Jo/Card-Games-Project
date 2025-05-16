package PokerGame;

import java.util.*;

public class PokerHandEvaluator {

 public static int compareHands(List<Card> hand1, List<Card> hand2) {
     int rank1 = evaluate(hand1);
     int rank2 = evaluate(hand2);

     return Integer.compare(rank1, rank2);
 }

 public static int evaluate(List<Card> hand) {
     Map<Integer, Integer> freq = new HashMap<>();
     boolean sameSuit = true;
     int[] values = new int[5];

     String suit = hand.get(0).getSuit();
     for (int i = 0; i < hand.size(); i++) {
         Card card = hand.get(i);
         values[i] = card.getValue();
         freq.put(card.getValue(), freq.getOrDefault(card.getValue(), 0) + 1);
         if (!card.getSuit().equals(suit)) sameSuit = false;
     }

     Arrays.sort(values);
     boolean straight = true;
     for (int i = 1; i < values.length; i++) {
         if (values[i] != values[i - 1] + 1) straight = false;
     }

     if (straight && sameSuit) return 8; // Straight Flush
     if (freq.containsValue(4)) return 7;
     if (freq.containsValue(3) && freq.containsValue(2)) return 6;
     if (sameSuit) return 5;
     if (straight) return 4;
     if (freq.containsValue(3)) return 3;
     if (Collections.frequency(freq.values(), 2) == 2) return 2; // Two Pair
     if (freq.containsValue(2)) return 1;
     return 0; // High Card
 }
}
