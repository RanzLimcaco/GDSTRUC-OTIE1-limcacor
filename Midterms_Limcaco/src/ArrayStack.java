import java.util.EmptyStackException;

public class ArrayStack {
    private Card[] stack;
    private int top;

    public ArrayStack(int capacity) {
        stack = new Card[capacity];
        top = -1;
    }

    //for the push operation
    public void push(Card card) {
        if (top == stack.length - 1) {
            Card[] newStack = new Card[stack.length * 2]; //increasing the size of stack array
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
        }
        stack[++top] = card;
    }

    // Check if empty
    public boolean isEmpty() {
        return top == -1;
    }

    //pop function
    public Card pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        Card poppedCard = stack[top];
        stack[top] = null;
        top--;
        return poppedCard;
    }

    // peak function
    public Card peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return stack[top];
    }

    //added size for printout
    public int size() {
        return top + 1;
    }

    public void printStack() {
        System.out.println("Print stack... ");

        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }

    }
}