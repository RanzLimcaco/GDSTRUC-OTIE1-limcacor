import java.util.EmptyStackException;

public class ArrayStack {
    private Player[] stack;
    private int top;

    public ArrayStack(int capacity){
        stack = new Player[capacity];
        top = -1;
    }


    //for the push operation
    public void push(Player p){
        // stack is already full
        if (top == stack.length - 1 ){
            Player[] newStack = new Player[stack.length * 2]; //increasing the size of stack array
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
        }

        stack[++top] = p;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    //pop function
    public Player pop() {
        if (isEmpty())
            throw  new EmptyStackException();

        Player poppedPlayer = stack[top];
        stack[top] = null;
        top--;
        return poppedPlayer;
    }

    //peak function
    public Player peek() {
        if (isEmpty())
            throw new EmptyStackException();

        return stack[top];
    }

    public void printStack() {
    System.out.println("Print stack... ");

        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }

    }

}
