import java.util.Objects;

public class PlayerLinkedList {
    private PlayerNode head;

    public void add(Player player) {
        PlayerNode node = new PlayerNode(player);
        node.setNextPlayer(head);
        head = node;
    }

    //Using the Linked List class, create a function that removes the first element, with the removed player as the return value.
    public Player removeFirst() {
        if (head == null) {
            return null;
        }
        Player removePlayer = head.getPlayer();
        head = head.getNextPlayer();

        System.out.println("\n");
        System.out.println("Removed player: " + removePlayer + "\n");
        return removePlayer;
    }

    //Using the Linked List class, create a size() function that determines how many elements are present in your Linked List.
    // Bonus if it's an in-place counter,
    // meaning it automatically updates the count whenever you remove or add an element.

    public int size() {
        int count = 0;
        PlayerNode currentNode = head;
        while (currentNode != null) {
            count++;
            currentNode = currentNode.getNextPlayer();
        }
        return count;
    }
//create a contains()
    public boolean contains(Player player) {
        PlayerNode currentNode = head;

        while (currentNode !=null) {
            if (currentNode.getPlayer().equals(player)) {
                return true;
            }

            currentNode= currentNode.getNextPlayer();
        }
        return false;
    }


    public void printList() {

        PlayerNode currentNode = head;

        System.out.println("HEAD");

        while (currentNode != null) {
            System.out.print("\n" + " -> " + currentNode.getPlayer());
            currentNode = currentNode.getNextPlayer();
        }

    }
}


