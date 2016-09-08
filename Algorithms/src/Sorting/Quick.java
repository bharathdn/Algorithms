package Sorting;

import java.util.Arrays;
import java.util.Random;

import org.omg.CORBA.INITIALIZE;

public class Quick {
    
    private static Random random;    // pseudo-random number generator
    private static long seed;        // pseudo-random number generator seed

    // static initializer
    static {
        // this is how the seed was set in Java 1.4
        seed = System.currentTimeMillis();
        random = new Random(seed);
    }

    
    public static void sort(Comparable[] array) {
        /*
         * code to shuffle the array to guarantee performance
         * this means, after partitioning, both sides of the partition 
         * will be in random order
         */
        shuffle(array);
        sort(array, 0, array.length - 1);
    }
    
    private static void sort(Comparable [] array, int lo, int hi) {
        if(hi <= lo)
            return;
        
        int j = partition(array, lo, hi);
        sort(array, lo, j-1);
        sort(array, j+1, hi);
    }
    
    /*
     * Get the Kth largest element in the array.
     * eg: in [1,5,6,8,2] ,, 5 is the 3rd largest 
     */
    public static Comparable select(Comparable[] array, int position) {
        shuffle(array);
        int lo = 0;
        int hi = array.length - 1;
        
        while(hi > lo) {
            int partitionIndex = partition(array, lo, hi);
            if(partitionIndex < position)
                lo = partitionIndex + 1;
            else if(partitionIndex > position)
                hi = partitionIndex - 1;
            else return array[position];
        }
        return array[position];
    }

    private static int partition(Comparable[] array, int lo, int hi) {
        int i = lo;
        int j = hi+1;
        
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
    
    /**
     * The code related to shuffle and uniform methods 
     * is from Princeton University Java library, 
     * given in the Algorithms course
     * Rearranges the elements of the specified array in uniformly random order.
     *
     * @param  a the array to shuffle
     * @throws NullPointerException if {@code a} is {@code null}
     */
    public static void shuffle(Object[] a) {
        if (a == null) throw new NullPointerException("argument array is null");
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = i + uniform(n-i);     // between i and n-1
            Object temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }
    
    /**
     * Returns a random integer uniformly in [0, n).
     * 
     * @param n number of possible integers
     * @return a random integer uniformly between 0 (inclusive) and {@code N} (exclusive)
     * @throws IllegalArgumentException if {@code n <= 0}
     */
    public static int uniform(int n) {
        if (n <= 0) throw new IllegalArgumentException("Parameter N must be positive");
        return random.nextInt(n);
    }
}