public class assignment1 {

    // Node Class
    static class Node {
        int key;
        Node next;

        Node(int key) {
            this.key = key;
            this.next = null;
        }
    }

    // LIST-INSERT (Insert at head)
    public static Node listInsert(Node head, Node x) {
        x.next = head;
        return x;
    }

    // LIST-SEARCH
    public static Node listSearch(Node head, int key) {
        Node current = head;
        while (current != null) {
            if (current.key == key) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // LIST-DELETE (delete by node reference)
    public static Node listDelete(Node head, Node x) {
        if (head == null) return null;

        if (head == x) {
            return head.next;
        }

        Node current = head;
        while (current.next != null && current.next != x) {
            current = current.next;
        }

        if (current.next == x) {
            current.next = x.next;
        }

        return head;
    }

    // Print list
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.key + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        Node head = null;

        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);

        head = listInsert(head, n1);
        head = listInsert(head, n2);
        head = listInsert(head, n3);

        System.out.print("Initial List: ");
        printList(head);

        Node found = listSearch(head, 20);
        System.out.println("Search 20: " + (found != null ? "Found" : "Not Found"));

        head = listDelete(head, n2);

        System.out.print("After deleting 20: ");
        printList(head);
    }
}