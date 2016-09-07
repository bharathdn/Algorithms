package stack;

import java.util.Iterator;

public class GenericArrayStack<Item> implements Iterable<Item> {

    private Item[] stack;
    private int currentSize = 0;
    
    @SuppressWarnings("unchecked")
    public GenericArrayStack(int capacity) {
        /*
         * A cast is necessary here because, Java does not allow 
         * declaration of Generic type arrays  
         */
        stack = (Item[]) new Object[capacity];
    }
    
    public boolean isEmpty() {
        return currentSize == 0;
    } 
    
    public void push(Item item) {
        stack[currentSize++] = item;
    }
    
    public Item pop() {
        return stack[currentSize--];
        
        /*
         * a better implementation to avoid loitering (keeping a 
         * reference when no longer needed) is =>
         * String item = stack[currentSize--];
         * stack[currentSize] = null;
         * return item;
         * 
         * this lets the item reference to stack[currentSize--]; to be 
         * garbage collected
         */
    }
    
    public Iterator<Item> iterator() {
        return new ReverArrayIterator();
    }
    
    private class ReverArrayIterator implements Iterator<Item> {
        private int currentIndex = currentSize;
        
        public boolean hasNext() {
            return currentIndex > 0;
        }
        
        public Item next() {
            return stack[--currentIndex];
        }
    }
}
