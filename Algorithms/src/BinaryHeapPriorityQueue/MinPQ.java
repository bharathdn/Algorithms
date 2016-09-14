package BinaryHeapPriorityQueue;

public class MinPQ<Key extends Comparable<Key>> {
    
    private Key[] priorityQueue;
    private int size;
    
    public MinPQ(int capacity) {
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
        while(k > 1 && greater(k/2, k))
        {
            exch(k ,k/2);
            k = k/2;
        }
    }
    
    private void sink(int k){
        while(2 * k <= size){
            int j = 2 * k;
            // check which child is larger
            if(j < size && greater(j, j+1))
                j++;
            // exchange if parent is less than largest of its children
            if(!greater(k, j))
                break;
            exch(k, j);
            k = j;
        }
    }
    
    private boolean greater(int a, int b) {
        return priorityQueue[b].compareTo(priorityQueue[a]) < 0;
    }

    private void exch(int i, int j) {
        Comparable swap = priorityQueue[i];
        priorityQueue[i] = priorityQueue[j];
        priorityQueue[j] = (Key) swap;
    }

}
