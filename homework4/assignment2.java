public class assignment2 {

    static class Node {
        int key;
        Node next;

        Node(int key) {
            this.key = key;
            this.next = null;
        }
    }

    // Insert at head
    public static Node insert(Node head, int key) {
        Node newNode = new Node(key);
        newNode.next = head;
        return newNode;
    }

    // Reverse list
    public static Node reverse(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    // Check palindrome
    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null)
            return true;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node secondHalf = reverse(slow);
        Node copySecondHalf = secondHalf;

        Node firstHalf = head;

        while (secondHalf != null) {
            if (firstHalf.key != secondHalf.key)
                return false;

            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        reverse(copySecondHalf); // restore list

        return true;
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.key + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        Node head = null;

        head = insert(head, 1);
        head = insert(head, 2);
        head = insert(head, 3);
        head = insert(head, 2);
        head = insert(head, 1);

        printList(head);

        if (isPalindrome(head))
            System.out.println("Palindrome");
        else
            System.out.println("Not a Palindrome");
    }
}