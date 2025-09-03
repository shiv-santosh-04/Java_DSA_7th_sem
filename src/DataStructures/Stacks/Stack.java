package DataStructures.Stacks;

// It's good practice to import exceptions you might use.
import java.util.EmptyStackException;

public class Stack {
    int[] arr;
    int top;
    int size;

    Stack(int size) {
        this.size = size;
        arr = new int[size];
        top = -1; // top is -1 when the stack is empty
    }

    /**
     * Pushes an element onto the top of the stack.
     */
    void push(int data) {
        if (top == size - 1) {
            // In real-world code, you'd throw an exception.
            // For example: throw new StackOverflowError("Stack is full");
            System.out.println("Stack is full:- Stack Overflow");
            return;
        }
        top++;
        arr[top] = data;
    }

    /**
     * Removes and returns the element at the top of the stack.
     */
    int pop() {
        if (isEmpty()) {
            // In real-world code: throw new EmptyStackException();
            System.out.println("Stack is empty:- Stack Underflow");
            return -1; // Return a value indicating an error
        }
        return arr[top--]; // Return the value, then decrement top
    }

    /**
     * Returns the element at the top of the stack without removing it.
     */
    int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return arr[top];
    }

    /**
     * Checks if the stack is empty.
     */
    boolean isEmpty() {
        return top == -1;
    }

    /**
     * Prints the elements of the stack from top to bottom.
     */
    void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.print("Stack (top to bottom): ");
        for (int i = top; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

class DriverCode {
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.printStack(); // Output: Stack (top to bottom): 30 20 10

        System.out.println("Popped element: " + stack.pop()); // Output: Popped element: 30
        System.out.println("Top element is now: " + stack.peek()); // Output: Top element is now: 20
        stack.printStack(); // Output: Stack (top to bottom): 20 10
    }
}