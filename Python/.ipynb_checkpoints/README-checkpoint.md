# 🃏 Python Card Games Collection

This repository contains simple Python implementations of classic card games designed for practice, learning, and fun. All games are playable via the command line and written with clarity for beginner to intermediate programmers.

## 🎮 Games Included

### 1. War
A two-player game where each player draws the top card of their deck and the higher card wins the round. The winner takes both cards. In case of a tie, a "war" occurs — each player places three cards face down and one face up. The higher face-up card wins all.

- **Objective**: Win all the cards.
- **Players**: 2
- **Rules**:
  - Cards are compared by rank only (suits ignored).
  - Game ends when one player collects all the cards or you set a limit.

---

### 2. Higher or Lower
The player is shown one card and must guess if the next card drawn will be higher or lower in rank.

- **Objective**: Make as many correct guesses in a row as possible.
- **Players**: 1
- **Rules**:
  - Aces are low (value = 1), Kings are high (value = 13).
  - Equal cards result in a loss by default.

---

### 3. Go Fish
Players ask each other for specific card ranks to form "books" (sets of four). If the player asked has the cards, they must give them up. If not, the asker draws from the deck ("Go Fish").

- **Objective**: Collect the most books (sets of 4).
- **Players**: 2+
- **Rules**:
  - Only ask for ranks you already hold.
  - If you draw the card you asked for, you go again.

---

### 4. Blackjack
Try to beat the dealer by getting a hand value as close to 21 as possible without going over.

- **Objective**: Have a higher hand than the dealer without busting (going over 21).
- **Players**: 1+ (Player vs Dealer)
- **Rules**:
  - Number cards = face value, face cards = 10, Ace = 1 or 11.
  - Player can `Hit` (draw card) or `Stand` (end turn).
  - Dealer must hit until reaching 17 or higher.

---

### 5. Poker (5-Card Draw - simplified)
Each player is dealt five cards. They may choose to discard and draw new ones once. The winner is the player with the highest-ranking hand.

- **Objective**: Make the best poker hand.
- **Players**: 2+
- **Rules**:
  - Basic poker hand ranking: Pair, Two Pair, Three of a Kind, Straight, Flush, Full House, Four of a Kind, Straight Flush, Royal Flush.
  - No betting phase included (simplified for learning purposes).

---