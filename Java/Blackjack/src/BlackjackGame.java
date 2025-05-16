import java.util.*;

public class BlackjackGame {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        System.out.println("Welcome to Blackjack!");
        List<Integer> playerHand = new ArrayList<>();
        List<Integer> dealerHand = new ArrayList<>();

        // Initial hands
        playerHand.add(drawCard());
        playerHand.add(drawCard());

        dealerHand.add(drawCard());
        dealerHand.add(drawCard());

        boolean playerTurn = true;
        boolean dealerTurn = true;

        // Player's Turn
        while (playerTurn) {
            System.out.println("Your hand: " + playerHand + " | Total: " + handTotal(playerHand));
            System.out.println("Dealer shows: " + dealerHand.get(0) + " and [hidden]");
            System.out.print("Hit or Stand? (h/s): ");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("h")) {
                playerHand.add(drawCard());
                if (handTotal(playerHand) > 21) {
                    System.out.println("You busted with " + handTotal(playerHand) + "! Dealer wins.");
                    return;
                }
            } else {
                playerTurn = false;
            }
        }

        // Dealer's Turn
        System.out.println("\nDealer's turn...");
        System.out.println("Dealer's hand: " + dealerHand + " | Total: " + handTotal(dealerHand));

        while (dealerTurn && handTotal(dealerHand) < 17) {
            dealerHand.add(drawCard());
            System.out.println("Dealer draws a card. New hand: " + dealerHand + " | Total: " + handTotal(dealerHand));
        }

        if (handTotal(dealerHand) > 21) {
            System.out.println("Dealer busted! You win!");
            return;
        }

        // Compare hands
        int playerTotal = handTotal(playerHand);
        int dealerTotal = handTotal(dealerHand);

        System.out.println("\nFinal Results:");
        System.out.println("Your hand: " + playerHand + " = " + playerTotal);
        System.out.println("Dealer's hand: " + dealerHand + " = " + dealerTotal);

        if (playerTotal > dealerTotal) {
            System.out.println("You win!");
        } else if (playerTotal < dealerTotal) {
            System.out.println("Dealer wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }

    // Draw a random card (2-11 for Ace)
    public static int drawCard() {
        int card = random.nextInt(13) + 1;
        if (card >= 11) return 10; // J, Q, K
        if (card == 1) return 11;  // Ace initially as 11
        return card;
    }

    // Calculate hand total with Ace logic
    public static int handTotal(List<Integer> hand) {
        int total = 0;
        int aces = 0;
        for (int card : hand) {
            total += card;
            if (card == 11) aces++;
        }
        while (total > 21 && aces > 0) {
            total -= 10; // Convert Ace from 11 to 1
            aces--;
        }
        return total;
    }
}

