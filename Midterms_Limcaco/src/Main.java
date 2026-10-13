import java.util.Random;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); //input checker
        Random random = new Random();


        //There should be 3 stacks (Player Hand, Player Deck, & Discard Pile)
        //The player deck, player hand, and discarded pile should work as a STACK. The next card to be drawn must be the top of the deck.
        CardStack deck = new CardStack(30); //player deck
        CardStack hand = new CardStack(30); // hand
        CardStack discardedPile = new CardStack(30); //discard



        // Contains 30 cards
        for (int i = 1; i <= 30; i++) {
            deck.push(new Card("Card " + i)); //push function
        }


        //Possible commands are:- Draw x cards (x can be a random value from 1 to 5)
        //- Discard x cards
        //- Get x cards from the discarded pile

        //loop

        //The program ends when the player deck is emptied.
        while (!deck.isEmpty()) {

            System.out.println("\n====================");
            System.out.println("    Game Start");
            System.out.println("====================");

            // Random command
            int command = random.nextInt(3);

            // Draw x cards (x can be a random value from 1 to 5)
            int amount = random.nextInt(5) + 1;


            //draw cards
            if (command == 0) {

                System.out.println("COMMAND: Draw " + amount + " card(s)");

                for (int i = 0; i < amount; i++) {

                    if (deck.isEmpty()) {
                        System.out.println("The deck is empty!");
                        break;
                    }

                    System.out.println("Next card: " + deck.peek());  // peek() used
                    Card card = deck.pop(); // pop() used
                    hand.push(card); // push() used
                    System.out.println("You drew: " + card);
                }
            }

            //Discard x cards

            else if (command == 1) {

                System.out.println("COMMAND: Discard " + amount + " card(s)");

                for (int i = 0; i < amount; i++) {

                    if (hand.isEmpty()) {
                        System.out.println("No cards to discard!");
                        break;
                    }

                    System.out.println("Card to discard: " + hand.peek());

                    Card card = hand.pop();
                    discardedPile.push(card);

                    System.out.println("Discarded: " + card);
                }
            }


            //- Get x cards from the discarded pile
            else {

                System.out.println("COMMAND: Get " + amount + " card(s) from discarded pile");


                for (int i = 0; i < amount; i++) {

                    if (discardedPile.isEmpty()) {
                        System.out.println("The Discard pile is empty!");
                        break;
                    }

                    System.out.println("Card to retrieve: " + discardedPile.peek());

                    Card card = discardedPile.pop();
                    hand.push(card);

                    System.out.println("Retrieved: " + card);
                }
            }

//After each round, the program must display the following info:- List of cards that the player is currently holding
//- Number of remaining cards in the player deck
//- Number of cards in the discarded pile

            System.out.println("\n================");
            System.out.println("CURRENT GAME STATE");
            System.out.println("================");

            System.out.println("\n Cards in hand:");
            hand.printStack();

            System.out.println(
                    "\nCards remaining in deck: " + deck.size()
            );

            System.out.println(
                    "Cards in discarded pile: " + discardedPile.size()
            );

            if (deck.isEmpty()) {
                System.out.println("\n====================");
                System.out.println("\nGAME OVER!");
                System.out.println("====================");
                System.out.println("The player deck is empty.");
                System.out.println("Final cards in hand: " + hand.size());
                System.out.println("Final cards discard pile: " + discardedPile.size());

                break;
            }

            //To proceed to next turn, player needs to press Enter
            System.out.println("\n Press ENTER to continue...");
            System.out.println("\n ===================NEW LINE====================");
            scanner.nextLine();
        }

        scanner.close();
    }
}
