package Sorting;

public class Quick {
    
    public static void sort(Comparable[] array) {
        /*
         * code to shuffle the array
         */
        sort(array, 0, array.length - 1);
    }
    
    private static void sort(Comparable [] array, int lo, int hi) {
        
        if(hi <= lo)
            return;
        
        int j = partition(array, lo, hi);
        sort(array, lo, j-1);
        sort(array, j+1, hi);
    }

    private static int partition(Comparable[] array, int lo, int hi) {
        int i = lo;
        int j = hi;
        
        while(true) {
            while(less(array[++i], array[lo])) 
                if(i == hi)
                    break;
            while(less(array[lo], array[--j]))
                if(j == lo)
                    break;
            if(i >= j)
                break;
            
            exch(array, i , j);
        }
        
        exch(array, lo , j);
        return j;
    }
    
    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
    
    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    
}