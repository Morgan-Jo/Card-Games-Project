import java.util.*;

public class GoFishGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();

        Player human = new Player("You");
        Player computer = new Player("Computer");

        // Deal 7 cards each
        for (int i = 0; i < 7; i++) {
            human.addCard(deck.drawCard());
            computer.addCard(deck.drawCard());
        }

        boolean playerTurn = true;
        while (!deck.isEmpty() && (human.getHand().size() > 0 || computer.getHand().size() > 0)) {
            Player current = playerTurn ? human : computer;
            Player opponent = playerTurn ? computer : human;

            System.out.println("\nDeck has " + deck.size() + " cards left.");
            System.out.println(current);

            String rankAsked = "";
            if (playerTurn) {
                System.out.print("Enter rank to ask for: ");
                rankAsked = scanner.nextLine();
                if (!current.hasRank(rankAsked)) {
                    System.out.println("You don't have that rank! Try again.");
                    continue;
                }
            } else {
                // Computer randomly picks a rank from its hand
                List<Card> oppHand = current.getHand();
                if (oppHand.isEmpty()) break;
                rankAsked = oppHand.get(new Random().nextInt(oppHand.size())).getRank();
                System.out.println("Computer asks: Do you have any " + rankAsked + "s?");
            }

            List<Card> received = opponent.giveCardsOfRank(rankAsked);
            if (!received.isEmpty()) {
                System.out.println(opponent.getName() + " gave " + received.size() + " card(s)!");
                current.addCards(received);
                current.checkForBooks(); // Check for books after receiving
            } else {
                System.out.println("Go Fish!");
                Card drawn = deck.drawCard();
                if (drawn != null) {
                    current.addCard(drawn);
                    System.out.println(current.getName() + " drew a " + drawn);
                    if (drawn.getRank().equals(rankAsked)) {
                        System.out.println("Lucky draw! " + current.getName() + " gets another turn.");
                        continue;
                    }
                }
            }

            current.checkForBooks();
            playerTurn = !playerTurn;
        }

        // End of game
        System.out.println("\nGame Over!");
        System.out.println("You made " + human.getBooks() + " books.");
        System.out.println("Computer made " + computer.getBooks() + " books.");

        if (human.getBooks() > computer.getBooks()) {
            System.out.println("You win!");
        } else if (human.getBooks() < computer.getBooks()) {
            System.out.println("Computer wins!");
        } else {
            System.out.println("It's a tie!");
        }

        scanner.close();
    }
}
