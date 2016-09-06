package stack;

public class FixedCapacityStackOfStrings {
    
    private String[] stack;
    private int currentSize = 0;
    
    public FixedCapacityStackOfStrings(int capacity) {
        stack = new String[capacity];
    }
    
    public boolean isEmpty() {
        return currentSize == 0;
    } 
    
    public void push(String item) {
        stack[currentSize++] = item;
    }
    
    public String pop() {
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
}
