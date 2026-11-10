public class Main {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.insert(25);
        binaryTree.insert(20);
        binaryTree.insert(15);
        binaryTree.insert(27);
        binaryTree.insert(30);
        binaryTree.insert(29);
        binaryTree.insert(26);
        binaryTree.insert(22);
        binaryTree.insert(32);


        System.out.println("In-order Traversal:");
        binaryTree.traverseInOrder();

        System.out.println("\nIn-order Descending:");
        binaryTree.traverseInOrderDescending();

        // minimum value
        System.out.println("\nMinimum Node:");
        System.out.println(binaryTree.getMin());

        // maximum value
        System.out.println("\nMaximum Node:");
        System.out.println(binaryTree.getMax());

        int findIndex = 15;
        System.out.println("\nNode with value " + findIndex + " = "
                + binaryTree.get(findIndex));
    }
}