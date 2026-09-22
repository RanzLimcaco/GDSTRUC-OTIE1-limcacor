public class Main {
    public static void main(String[] args) {
        PlayerLinkedList playerList = new PlayerLinkedList();
        playerList.add(new Player(1,"Goku", 500));
        playerList.add(new Player(2,"Saitama", 999));
        playerList.add(new Player(3,"Sakamoto", 10));
        playerList.add(new Player(4,"Tester", 95));

        playerList.printList();
        playerList.removeFirst();
        playerList.printList();
        System.out.println("\n" + "Size: " + playerList.size());

        boolean hasPlayer = playerList.contains(new Player(4, "Tester", 95)); //testing if false
        System.out.println("Player found:" + hasPlayer + "\n");

    }
}
