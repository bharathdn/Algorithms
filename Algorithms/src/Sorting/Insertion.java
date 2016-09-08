package Sorting;

public class Insertion {

    public static void sort(Comparable [] array) {
        int N = array.length;
        
        for(int i = 0; i < N; i++) {
            for(int j = i-1; j > 0; j--) 
                if(less(array[j], array[j-1]))
                    exch(array, j, j-1);
                else 
                    break;
        }
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
