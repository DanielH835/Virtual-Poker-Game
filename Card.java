/* Card.java
 * This class creates the card's Rank and Suit. 
 * Compares ranks to sort from smallest to largest
 * and suits from weakest to strogest.
 */ 

public class Card implements Comparable<Card> {
	
	private int suit; 
	private int rank; 
       
	public Card(int s, int r) {
		
		suit = s;
        rank = r;
	}
	
	public int compareTo(Card c) {
		
        if (rank < c.rank) {
            return -1;    
        }
        else if (rank > c.rank) {
            return 1;
        }
        else{
            if (suit < c.suit) {
                return -1;
            }
            else {
                return 1;
            }
        }
		
	}
	
	public String toString() { // returns a string representation of a card.
		
		switch (suit) {
            case 1: return rank + " of Clubs";
            case 2: return rank + " of Diamonds";
            case 3: return rank + " of Hearts";
            default: return rank + " of Spades"; 
                
        }
     
	}
    
	public int getRank() {
        return rank;
    }
    
    public int getSuit() {
        return suit;
    }    

}
