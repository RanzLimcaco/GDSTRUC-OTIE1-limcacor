import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); //input checker
        Random random = new Random();


        //There should be 3 stacks (Player Hand, Player Deck, & Discard Pile)
        //The player deck, player hand, and discarded pile should work as a STACK. The next card to be drawn must be the top of the deck.
        CardStack deck = new CardStack(30); // Player deck


        CardStack discardedPile = new CardStack(30); // Discard pile


        ArrayList<Card> hand = new ArrayList<>(); // Player's hand



        // Contains 30 cards
        for (int i = 1; i <= 30; i++) {
            deck.push(new Card("Card " + i));
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


            if (command == 0) {

                System.out.println("COMMAND: Draw " + amount + " card(s)");

                for (int i = 0; i < amount; i++) {

                    if (deck.isEmpty()) {
                        System.out.println("The deck is empty!");
                        break;
                    }

                    Card card = deck.pop();
                    hand.add(card);

                    System.out.println("You Drew: " + card);
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

                    // card from removal from hand
                    Card card = hand.remove(hand.size() - 1);
                    discardedPile.push(card);

                    System.out.println("Discarded cards: " + card);
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

                    Card card = discardedPile.pop();
                    hand.add(card);

                    System.out.println("Retrieved Cards: " + card);
                }
            }

//After each round, the program must display the following info:- List of cards that the player is currently holding
//- Number of remaining cards in the player deck
//- Number of cards in the discarded pile

            System.out.println("\n================");
            System.out.println("CURRENT GAME STATE");
            System.out.println("================");

            System.out.println("\n Cards in hand:");

            if (hand.isEmpty()) {
                System.out.println("No cards left");
            } else {
                for (Card card : hand) {
                    System.out.println("- " + card);
                }
            }

            System.out.println("\n Cards remaining in deck: " + deck.size());

            System.out.println("Cards in discarded pile: " + discardedPile.size());


            if (deck.isEmpty()) {
                System.out.println("\nGAME OVER!");
                System.out.println("The player deck is empty.");
                break;
            }

            //To proceed to next turn, player needs to press Enter
            System.out.println("\n Press ENTER to continue...");
            scanner.nextLine();
        }

        scanner.close();
    }
}
