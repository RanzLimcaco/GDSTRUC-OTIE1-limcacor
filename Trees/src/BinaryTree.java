
public class BinaryTree {
    private Node root;

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
        }
        else {
            root.insert(value);
        }
    }

    public void traverseInOrder() {
        if (root != null)
            root.traverseInOrder();
    }

    // traverses the tree using the in-order method but in descending order.
    public void traverseInOrderDescending() {
        if (root != null)
            root.traverseInOrderDescending();
    }

    // gets the node with the least value in the tree
    public Node getMin() {
        if (root == null)
            return null;

        return root.getMin();
    }

    // gets the node with the maximum value in the tree
    public Node getMax() {
        if (root == null)
            return null;

        return root.getMax();
    }

    public Node get(int value) {
        if (root != null)
            return root.get(value);

        return null;
    }
}
