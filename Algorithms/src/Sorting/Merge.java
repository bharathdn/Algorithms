package Sorting;

import java.util.Arrays;

public class Merge {

    public static void sort(Comparable[] array) {
        Comparable[] aux = new Comparable[array.length];
        sort(array, aux, 0, array.length-1);
    }

    private static void sort(Comparable[] array, Comparable[] aux, int lo, int hi) {
        if(hi <= lo)
            return;
        int mid = lo + (hi - lo) / 2;
        sort(array, aux, lo, mid);
        sort(array, aux, mid+1, hi);
        merge(array, aux, lo, mid, hi);
    } 

    private static void merge(Comparable[] array, Comparable[] aux, int lo, int mid, int hi) {
        assert isSorted(array, lo , mid);
        assert isSorted(array, mid+1, hi);

        for(int i  = lo; i <= hi; i++)
            aux[i] = array[i];

        int j = lo; 
        int k = mid+1;

        for(int i = lo; i <= hi; i ++){
            if(j > mid)
                array[i] = aux[k++];
            else if(k > hi)
                array[i] = aux[j++];
            else if(less(aux[j], aux[k]))
                array[i] = aux[j++];
            else
                array[i] = aux[k++];
        }

        assert isSorted(array, lo, hi);
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for(int i = lo+1; i < hi; i++)
            if(less(a[i], a[i-1]))
                return false;
        return true;
    }

    private static boolean isSorted(Comparable[] a) {
        for(int i = 1; i < a.length; i++)
            if(less(a[i], a[i-1]))
                return false;
        return true;
    }
 }
