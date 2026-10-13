import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayQueue queue = new ArrayQueue(3);
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int playerId = 1;
        int gamesCreated = 0;

        final int maxGames = 10; //final 10 games
        final int playersPerGame = 5; //a game can be started when at atleast 5 players are in the queue

        System.out.println("=== WARDOGS MATCHMAKING SYSTEM ===");

        while (gamesCreated < maxGames) {

            //1.Every turn, x players will be enqueued for matching(x = rand()1 to 7).
            int playersToAdd = random.nextInt(7) + 1;

            System.out.println("\nPlayers are joining this turn: "
                    + playersToAdd);

            for (int i = 0; i < playersToAdd; i++) {
                int level = random.nextInt(200) + 1;

                Player player = new Player(
                        playerId,
                        "Mercenary " + playerId,
                        level
                );

                queue.enqueue(player);
                playerId++;
            }

            // Show all waiting players
            System.out.println("\nCurrent Queue:");
            queue.printQueue();

            System.out.println("\nPlayers waiting in queue: " + queue.size());

            //Pressing enter ends the turn.
            System.out.println("\nPress Enter to end this turn...");
            scanner.nextLine();

            // Create as many games as possible
            while (queue.size() >= playersPerGame
                    && gamesCreated < maxGames) {

                gamesCreated++;

                System.out.println("\n");
                System.out.println("\n=== GAME " + gamesCreated + " CREATED ===");

                for (int i = 1; i <= playersPerGame; i++) {
                    Player player = queue.dequeue();

                    System.out.println(i + ". " + player);
                }
                System.out.println("\n");

                System.out.println("Game " + gamesCreated + " successfully started!");

                System.out.println("\n");

                System.out.println("Players remaining: " + queue.size());
            }
        }

        System.out.println("\n=== MATCHMAKING FINISHED ===");
        System.out.println("Total games created: " + gamesCreated);
        System.out.println("Players remaining: " + queue.size());

        scanner.close();
    }
}
