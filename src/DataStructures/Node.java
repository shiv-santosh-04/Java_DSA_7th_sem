package DataStructures;

public class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SSL {
    Node head;
    int size;

    SSL() {
        head = null;
        size = 0;
    }

    void insertAtHead(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    void insertAtTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            size++;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        size++;
    }

    void insertAtPosition(int data, int position) {
        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position for insertion.");
            return;
        }
        if (position == 1) {
            insertAtHead(data);
            return;
        }

        Node newNode = new Node(data);
        Node current = head;
        for (int i = 1; i < position - 1; i++) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

class Drivercode {
    public static void main(String[] args) {
        SSL ssl = new SSL();
        ssl.insertAtTail(10);
        ssl.insertAtTail(20);
        ssl.insertAtTail(40);
        ssl.insertAtTail(50);

        System.out.println("Original Linked List:");
        ssl.printList(); // Output: 10 -> 20 -> 40 -> 50 -> null

        // Insert 30 at position 3
        ssl.insertAtPosition(30, 3);
        System.out.println("\nLinked List after inserting 30 at position 3:");
        ssl.printList(); // Output: 10 -> 20 -> 30 -> 40 -> 50 -> null

        // Insert 5 at position 1 (head)
        ssl.insertAtPosition(5, 1);
        System.out.println("\nLinked List after inserting 5 at position 1:");
        ssl.printList(); // Output: 5 -> 10 -> 20 -> 30 -> 40 -> 50 -> null
    }
}