// Game.java

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Game {
	
	private Player p;
	private Deck cards;
    private double bet;
    
	
	public Game(String[] testHand) {
        // Command line argument. Here I check if my hands are correct.
        p = new Player(converter(testHand));
        cards = new Deck();
        bet = 0;
        
	}
	
	public Game() {
		p = new Player();
        cards = new Deck();
        bet = 0;
        
	}
	
	public void play() {
		Scanner s = new Scanner(System.in);
        String playOrNot;
        boolean keepPlaying = true;
		System.out.println("Hello, welcome to Video Poker!!");
        
        while (keepPlaying) {
            // while the user presses Y keepPlaying is true
            // and a new game is created.
            
            if (p.getHand().isEmpty()){
                // This is where I play a regular game of Poker.
                // No initial given hand.
                
                System.out.println("You have " + p.getBankroll()
                                   + " dollars in your bank.");
                System.out.println("Please put an intial amount of bet: ");
                bet = s.nextDouble();
                p.bets(bet);
            
                for (int i=0; i<5; i++) {
                    // Deals 5 cards from the top of the deck.
                    p.addCard(cards.deal());
                
                }
        
                System.out.println("Your starting hand is: " + p.getHand());
                System.out.println("How many cards would you like to trade?");
                int trade = s.nextInt();
        
                for (int i=0; i<trade; i++) {
                    // A loop for the number of cards the player wants to remove.
                    System.out.println("Which card location do you want to" 
                                       + "remove? 1-" + (5-i));
                    int location = s.nextInt();
                    p.getHand().remove(location-1);
                    System.out.println("Your current hand is " + p.getHand());
                }
        
                for (int i=0; i<trade; i++) {
                    // Adds the same amount of cards removed.
                    p.addCard(cards.deal());
                }
            }
            checkHand(p.getHand());
            
            System.out.println("You've won " + p.getWinnings() + " dollars.");
            System.out.println("Your final hand was " + p.getHand());
            
            if (p.getBankroll()<1) {
                System.out.println("Sorry, you ran out of cash. GAME OVER!");
                break;
            } 
            
            System.out.println("");
            System.out.println("Would you like to keep playing??");
            System.out.println("Press Y for yes, N for no.");
            playOrNot = s.next();
            
            if (playOrNot.equals("Y")) {
                // The player must answer if he/she wants to keep playing.
                keepPlaying = true;
            }
            else {
                System.out.println("Thank you for playing! See you next time.");
                keepPlaying = false;
            }

        p.getHand().clear();
        cards = new Deck();    
            
        }
	}
	
	public String checkHand(ArrayList<Card> hand) {
        // This method is taking the player's cards and checks for the highest hand.
        Collections.sort(hand);
        
        if (checkRoyalFlush(hand)) {
            System.out.println("");
            System.out.println("Congrats you've got a RoyalFlush!!");
            p.winnings(250);
            return hand.toString();
        }
        else if (checkStraightFlush(hand)) {
            System.out.println("");
            System.out.println("Congrats you've got a StraightFlush!!");
            p.winnings(50);
            return hand.toString();
        }
        else if (checkFourOfKind(hand)) {
            System.out.println("");
            System.out.println("Congrats you've got Four of a Kind!!");
            p.winnings(25);
            return hand.toString();
        }
        else if (checkFullHouse(hand)) {
            System.out.println("");
            System.out.println("Congrats you've got FullHouse!!");
            p.winnings(6);
            return hand.toString();
        }
        else if (checkFlush(hand)) {
            System.out.println("");
            System.out.println("Congrats you've got a Flush!!");
            p.winnings(5);
            return hand.toString();
        }
        else if (checkStraight(hand)) {
            System.out.println("");
            System.out.println("Congrats you've got a Straight!!");
            p.winnings(4);
            return hand.toString();
        }
        else if (checkThreeOfKind(hand)) {
            System.out.println("");
            System.out.println("Congrats you've got Three of a Kind!!");
            p.winnings(3);
            return hand.toString();
        }
        else if (checkTwoPairs(hand)) {
            System.out.println("");
            System.out.println("Congrats you've got Two Pairs!!");
            p.winnings(2);
            return hand.toString();
        }
        else if (checkOnePair(hand)) {
            System.out.println("");
            System.out.println("Congrats you've got one pair!!");
            p.winnings(1);
            return hand.toString();
        }
        else {
            System.out.println("");
            System.out.println("Sorry you've got NOTHING!");
            return hand.toString();
        }
        
	}
	
	public ArrayList<Card> converter(String[] givenHand) {
        // Converts command line given hand into an integer representation.
        ArrayList<Card> a = new ArrayList<Card>();
        Card d;
        int suit;
        int rank;
        
        for (int i=0; i<givenHand.length; i++) {
            if (givenHand[i].charAt(0) == 'c') {
                suit = 1;
            }
            else if (givenHand[i].charAt(0) == 'd') {
                suit = 2;
            }
            else if (givenHand[i].charAt(0) == 'h') {
                suit = 3;
            }
            else {
                suit = 4;
            }
            
            rank = Integer.parseInt(givenHand[i].substring(1));
        
            d = new Card(suit,rank);
            a.add(d);
            
        }
        
        return a;
    }   
        
    public boolean checkOnePair(ArrayList<Card> hand) { 
        for (int i=0; i<hand.size(); i++) {
            for (int j=i+1; j<hand.size(); j++) {
                if (hand.get(i).getRank() == hand.get(j).getRank()) {
                    return true;
                }
            }
        }
        
        return false;    
    }
    
    public boolean checkTwoPairs(ArrayList<Card> hand) {
        int pair = 0;
        
        for (int i=0; i<3; i++) {
            for (int j=i+1; j<3; j++) {
                if (hand.get(i).getRank() == hand.get(j).getRank()) {
                    pair++;
                }
            }
        }
        
        for (int i=3; i<5; i++) {
            for (int j=i+1; j<5; j++) {
                if (hand.get(i).getRank() == hand.get(j).getRank()) {
                   pair++;
                }
            }
        } 
        
        if (pair == 2 && hand.get(1).getRank() != hand.get(3).getRank()) {
            return true;
        } 
        
        return false; 
    }
    
    public boolean checkThreeOfKind(ArrayList<Card> hand) {
        if ((hand.get(0).getRank() == hand.get(1).getRank() && 
             hand.get(2).getRank() == hand.get(0).getRank()) || 
            (hand.get(1).getRank() == hand.get(2).getRank() && 
             hand.get(3).getRank() == hand.get(1).getRank()) ||
            (hand.get(2).getRank() == hand.get(3).getRank() && 
             hand.get(4).getRank() == hand.get(2).getRank())) {
            return true;
        }
        
        return false;
    }
    
    public boolean checkFourOfKind(ArrayList<Card> hand) {
        if ((hand.get(0).getRank() == hand.get(3).getRank()) || 
            (hand.get(1).getRank() == hand.get(4).getRank())) {
            return true;
        }
        
        return false;
    }
    
    public boolean checkStraight(ArrayList<Card> hand) {
        if (hand.get(4).getRank() - hand.get(0).getRank() == 4 &&
            hand.get(1).getRank() != hand.get(2).getRank()) {
            return true;
        }
        else if(hand.get(0).getRank() == 1 &&
                hand.get(1).getRank() == 10 &&
                hand.get(2).getRank() == 11 &&
                hand.get(3).getRank() == 12 &&
                hand.get(4).getRank() == 13) {
            return true;
        }
        else {
            return false;
            
        }
    }
    
    public boolean checkFlush(ArrayList<Card> hand) {
        for (int i=0; i<5; i++) {
            for (int j=i+1; j<5; j++) {
                if (hand.get(i).getSuit() != hand.get(j).getSuit()) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean checkFullHouse(ArrayList<Card> hand) {
        if (checkThreeOfKind(hand) && checkTwoPairs(hand)) {
            return true;
        }
        
        return false;
    }
    
    public boolean checkStraightFlush(ArrayList<Card> hand) {
        if (checkFlush(hand) && checkStraight(hand) 
           && hand.get(4).getRank() != 13) {
            return true;
        }
        
        return false;
    }
    
    public boolean checkRoyalFlush(ArrayList<Card> hand) {
        if (checkFlush(hand) && checkStraight(hand) 
           && hand.get(4).getRank() == 13) {
            return true;
        }
        
        return false;
    }
    
}
