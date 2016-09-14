package BinaryHeapPriorityQueue;

public class MaxPQ<Key extends Comparable<Key>> {
    
    private Key[] priorityQueue;
    private int size;
    
    public MaxPQ(int capacity) {
        priorityQueue = (Key[]) new Comparable[capacity + 1];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public void insert(Key value){
        priorityQueue[++size] = value;
        swim(size);
    }
    
    public Key delMax(){
        Key max = priorityQueue[1];
        exch(1, size--);
        sink(1);
        priorityQueue[size + 1] = null;
        return max;
    }
    
    private void swim(int k){
        while(k > 1 && less(k/2, k))
        {
            exch(k ,k/2);
            k = k/2;
        }
    }
    
    private void sink(int k){
        while(2 * k <= size){
            int j = 2 * k;
            if(j < size && less(j, j+1))
                j++;
            if(!less(k, j))
                break;
            exch(k, j);
            k = j;
        }
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
