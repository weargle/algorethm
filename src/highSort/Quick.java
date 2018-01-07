package highSort;

import baseSort.Insert;
import common.SortTest;

/**
 * 快速排序
 */
public class Quick {

    public static void main(String[] args) {
        int n = 10000;
        Integer[] arr = SortTest.generate(n, 0, 10);

        long start = System.currentTimeMillis();
        sort(arr);
        long end = System.currentTimeMillis();

        long time  = end - start;

//        for (int i = 0; i < n; i++) {
//            System.out.print(arr[i] + " ");
//        }
        System.out.println();
        System.out.print(time);
    }

    public static void sort(Comparable[] arr) {

        int n = arr.length;

        sort(arr, 0, n - 1);
    }

    private static void sort(Comparable[] arr, int l, int r) {

/*        if (l >= r) {
            return;
        }*/
        if (r - l <= 11) {
            Insert.sort(arr, l, r);
            return;
        }

        int p = partition(arr, l, r);

        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    public static int partition(Comparable[] arr, int l, int r) {

        swap(arr, l, (int)(Math.random() * (r - l + 1)) + l);
        Comparable t = arr[l];
        int j = l;

        for (int i = l + 1; i <= r; i++) {

            if (arr[i].compareTo(t) < 0) {
                arr[j + 1] = arr[i];
                j++;
            }
        }

        swap(arr, l, j);

        return j;
    }

    private static void swap(Comparable[] arr, int l, int j) {

        Comparable a = arr[j];
        arr[j] = arr[l];
        arr[l] = a;
    }
}
