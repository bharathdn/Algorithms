package Sorting;

public class Selection {
    public static void sort(Comparable [] array) {
        int N = array.length;
        
        for(int i = 0; i < N; i++) {
            int min = i;
            for(int j = 0; j < N; j++) {
                if(less(array[j], array[min]))
                    min = j;
            }
            exch(array, i, min);
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
