import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WarGame {

    public static void main(String[] args) {
        List<Integer> deck = new ArrayList<>();
        for (int i = 2; i <= 14; i++) {  // Cards 2 to Ace (Ace = 14)
            for (int j = 0; j < 4; j++) {
                deck.add(i);
            }
        }

        Collections.shuffle(deck);

        Queue<Integer> player1 = new LinkedList<>();
        Queue<Integer> player2 = new LinkedList<>();

        for (int i = 0; i < deck.size(); i++) {
            if (i % 2 == 0) player1.add(deck.get(i));
            else player2.add(deck.get(i));
        }

        int round = 1;
        while (!player1.isEmpty() && !player2.isEmpty()) {
            System.out.println("Round " + round++);
            int card1 = player1.poll();
            int card2 = player2.poll();
            System.out.println("Player 1 plays: " + card1 + " | Player 2 plays: " + card2);

            if (card1 > card2) {
                player1.add(card1);
                player1.add(card2);
                System.out.println("Player 1 wins the round.\n");
            } else if (card2 > card1) {
                player2.add(card2);
                player2.add(card1);
                System.out.println("Player 2 wins the round.\n");
            } else {
                System.out.println("War! (Tie) Cards are discarded.\n");
                // Simplified: discard cards in a tie
            }
        }

        if (player1.isEmpty()) System.out.println("Player 2 wins the game!");
        else System.out.println("Player 1 wins the game!");
    }
}

