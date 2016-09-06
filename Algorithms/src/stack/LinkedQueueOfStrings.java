package stack;

public class LinkedQueueOfStrings {

    private Node last = null;
    private Node first = null;

    private class Node {
        String item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void enque(String item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;

        if(isEmpty()) {
            first = last;
            return;
        }
        oldLast.next = last;
    }

    public String deque() {
        String item = first.item;
        first = first.next;
        if(isEmpty())
            last = null;
        return item;

    }
}
