/* Deck.java
 * This class creates a deck of 52 cards, shuffles the deck,
 * identifies the top card and deals.
 */ 

import java.util.Random;

public class Deck {
	
	private Card[] cards;
	private int top; 

	public Deck() { 
        //This constructor creates a deck of 52 cards. 13 numbers of each suit.
        cards = new Card[52];
        for (int i=0; i<52; i++) {
            cards[i] = new Card((i/13)+1,(i%13)+1);
        }
        
		top = 51;
        shuffle();
	}
	
	public void shuffle() {
        // shuffles two cards at a time. 200 times.
		Random ranCard = new Random();
        Card temporary;
        int location;
        int location2;
        
        for (int i=0; i<200; i++) {
            location = ranCard.nextInt(52);
            location2 = ranCard.nextInt(52);
            temporary = cards[location];
            cards[location] = cards[location2];
            cards[location2] = temporary;
            
        }    
        
    }    
        
	public Card topCard() {
        return cards[top];
        
    }
    
	public Card deal() {
		return cards[top--];		
	}
    

}
