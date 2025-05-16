import java.util.*;

public class Player {
    private String name;
    private List<Card> hand;
    private int books;

    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
        books = 0;
    }

    public void addCard(Card c) {
        hand.add(c);
    }

    public void addCards(List<Card> cardsToAdd) {
        hand.addAll(cardsToAdd);
    }

    public List<Card> giveCardsOfRank(String rank) {
        List<Card> cardsToGive = new ArrayList<>();
        Iterator<Card> it = hand.iterator();
        while (it.hasNext()) {
            Card c = it.next();
            if (c.getRank().equals(rank)) {
                cardsToGive.add(c);
                it.remove();
            }
        }
        return cardsToGive;
    }

    public boolean hasRank(String rank) {
        for (Card c : hand) {
            if (c.getRank().equals(rank)) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public int getBooks() {
        return books;
    }

    public void checkForBooks() {
        Map<String, Integer> rankCount = new HashMap<>();
        for (Card c : hand) {
            rankCount.put(c.getRank(), rankCount.getOrDefault(c.getRank(), 0) + 1);
        }

        for (String rank : rankCount.keySet()) {
            if (rankCount.get(rank) == 4) {
                // remove all cards of this rank
                hand.removeIf(c -> c.getRank().equals(rank));
                books++;
                System.out.println(name + " completed a book of " + rank + "s!");
            }
        }
    }

    public String toString() {
        return name + "'s hand: " + hand;
    }
}
