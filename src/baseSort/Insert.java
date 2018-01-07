package baseSort;

import common.SortTest;

import java.util.Arrays;

public class Insert {

    private Insert(){}

    public static void main(String[] args) {

        int n = 100;
        Integer[] arr = SortTest.generate(n, 0, n);
        sort(arr);
    }

    public static void sort(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Comparable a = arr[i];
            int j;
            for (j = i; j > 0 && arr[j - 1].compareTo(a) > 0; j--) {
                arr[j] = arr[j - 1];
            }

            arr[j] = a;
        }
    }

    public static void sort(Comparable[] arr, int l, int r) {
        for (int i = l + 1; i < r + 1; i++) {
            Comparable e = arr[i];

            int j;
            for (j = i; j > l && arr[j - 1].compareTo(e) > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = e;

        }
    }

    private <T> void swap(T[] arr, int i, int j) {
        T a = arr[i];
        arr[i] = arr[j];
        arr[j] = a;
    }
}
