package elementaryPriorityQueue;

import java.util.PriorityQueue;

public class UnorderedMaxPQ<Key extends Comparable<Key>> {

    private Key[] priorityQueue;
    private int size;

    @SuppressWarnings("unchecked")
    public UnorderedMaxPQ(int capacity){
        priorityQueue = (Key[]) new Comparable[capacity]; 
    }

    void insert(Key value){
        priorityQueue[size++] = value; 
    }

    public Key delMax(){
        if(isEmpty())
            return null;

        int max = 0;
        for(int i = 0; i < size; i++){
            if(less(max, i))
                max = i;
        }
        exch(max, size-1);
        // null out entry to prevent loitering
        return priorityQueue[--size];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private boolean less(int a, int b) {
        return priorityQueue[a].compareTo(priorityQueue[b]) < 0;
    }

    private void exch(int i, int j) {
        Comparable swap = priorityQueue[i];
        priorityQueue[i] = priorityQueue[j];
        priorityQueue[j] = (Key) swap;
    }
}
