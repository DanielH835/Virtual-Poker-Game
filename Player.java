/* Player.java
 * This class creates a player with all of it's characteristics.
 * Array of 5 cards, bankroll with random amount of money,
 * and options of removing and adding cards to the player's hand.
 */ 

import java.util.ArrayList;

public class Player {
		
	private ArrayList<Card> hand; // the player's hand.
	private double bankroll;
    private double bet;
    private double amountWon;

	public Player(ArrayList<Card> myHand) {
        // The player is choosing a hand. The checking part.
        hand = myHand;
        bankroll = Math.ceil(Math.random() * 20);
        bet = 0;
        amountWon = 0;
    }
		
	public Player() {
        // The player is given a random hand and a random amount of cash.
	    hand = new ArrayList<Card>();
        bankroll = Math.ceil(Math.random() * 5);
        bet = 0;
        amountWon = 0;
	}

	public void addCard(Card c) {
	    hand.add(c);
	}

	public void removeCard(Card c) {
        // I used the remove method of ArrayList instead of this method.
	    hand.remove(c);
    }
		
    public void bets(double amt) {
        bet = amt;
        bankroll -= bet;
        
    }    
    
    public void winnings(double odds) { 
        //adjust bankroll if player wins
        amountWon = bet * odds;
        bankroll += amountWon;
        
    }

    public double getBankroll() { 
        // return current balance of bankroll
        return bankroll;
            
    }

    public double getWinnings() {
        return amountWon;
    }
    
    public String toString() {
        return hand.toString();
    }
    
    public ArrayList<Card> getHand() {
        return hand;
    }
}
