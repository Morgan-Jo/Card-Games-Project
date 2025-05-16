import java.util.*;

public class HigherOrLower {
    static final String[] RANKS = {
        "Ace", "2", "3", "4", "5", "6", "7",
        "8", "9", "10", "Jack", "Queen", "King"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        int currentCard = rand.nextInt(13) + 1;
        int score = 0;

        System.out.println("Welcome to Higher or Lower!");
        System.out.println("Current card is: " + RANKS[currentCard - 1]);

        while (true) {
            System.out.print("Will the next card be higher or lower? (h/l or q to quit): ");
            String guess = scanner.nextLine().toLowerCase();

            if (guess.equals("q")) {
                System.out.println("Game over. Final score: " + score);
                break;
            }

            int nextCard = rand.nextInt(13) + 1;
            System.out.println("Next card is: " + RANKS[nextCard - 1]);

            if ((guess.equals("h") && nextCard > currentCard) ||
                (guess.equals("l") && nextCard < currentCard)) {
                score++;
                System.out.println("Correct! Score: " + score);
                currentCard = nextCard;
            } else if (nextCard == currentCard) {
                System.out.println("It's a tie. No points awarded.");
            } else {
                System.out.println("Wrong! Game over.");
                System.out.println("Final score: " + score);
                break;
            }
        }

        scanner.close();
    }
}
