Virtual Poker Game.

This game has two parts:
1. Command Line argument: This part is to check all available hands
and their accuracy.

2. Regular Poker game: The player is playing against him/her self. an array of five random cards is given at the beginning of the game. 
Since it is a one round game (you either won or lost), the player must bet
before seeing the given hand. Then, for one time only, the player is allowed to 
change as many cards as wished from 0 to all and swapping them with the same 
amount of newly random cards from the same shuffled deck.
After fixing the array of cards the player's hand is compared with the different
check methods to see how strong the hand is and respectively how much money 
was earned/lost.

Classes:
* Card class: the card class creates a simple card with a rank ranges from 1-13
and a suit of Clubs-Diamonds-Hearts-Spades. 

* Deck class: the deck class creates a 52 cards pack. 13 numbers assigned by 
four different suits. The deck gets shuffled every new beginning of game.

* Player class: the player class is responsible of creating a player who has
a random amount of cash, array of 5 random cards, and methods of adding and 
removing unwanted cards from the given hand.

* Game class: the game class is responsible of playing the game and integrates
all classes while playing. A part of the game class is checking for strengths
of compared cards and assigning the payoff for each hand.

* PokerTest class: this class is the tester where the game gets initialized.
two options:
1. game class does not take anything and a regular game starts.
2. game class take a parameter "args" as a command line argument with a fixed 
hand only to make sure the array matches the right pair identity.
