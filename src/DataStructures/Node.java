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

    void deleteAtHead() {
        if (head != null) {
            head = head.next;
            size--;
        }
    }

    void deleteAtPosition(int position) {
        if (position < 1 || position > size) {
            System.out.println("Invalid position for deletion.");
            return;
        }
        if (position == 1) {
            deleteAtHead();
            return;
        }

        Node current = head;
        for (int i = 1; i < position - 1; i++) {
            current = current.next;
        }

        Node nodeToDelete = current.next;
        current.next = nodeToDelete.next;
        size--;
    }

    void deleteByValue(int value) {
        // Case 1: The head node is the one to be deleted
        if (head != null && head.data == value) {
            deleteAtHead();
            return;
        }

        // Case 2: The node is somewhere in the middle or at the tail
        Node current = head;
        Node previous = null;

        while (current != null && current.data != value) {
            previous = current;
            current = current.next;
        }

        // If the value was not found in the list
        if (current == null) {
            System.out.println("Node with value " + value + " not found.");
            return;
        }

        // Unlink the node from the list
        previous.next = current.next;
        size--;
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
        ssl.insertAtTail(30);
        ssl.insertAtTail(40);

        System.out.println("Original Linked List:");
        ssl.printList(); // 10 -> 20 -> 30 -> 40 -> null

        ssl.deleteByValue(30);
        System.out.println("\nLinked List after deleting 30:");
        ssl.printList(); // 10 -> 20 -> 40 -> null

        ssl.deleteByValue(10);
        System.out.println("\nLinked List after deleting 10:");
        ssl.printList(); // 20 -> 40 -> null

        ssl.deleteByValue(50);
        System.out.println("\nLinked List after trying to delete 50 (not found):");
        ssl.printList(); // 20 -> 40 -> null
    }
}