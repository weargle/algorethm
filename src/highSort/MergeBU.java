package highSort;

import java.util.Arrays;

/**
 * 自底向上的归并排除
 */
public class MergeBU {

    public MergeBU() {
    }

    public static void main(String[] args){
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8};

        sort(arr);

        for (int i = 0 ; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void sort(Comparable[] arr, int n) {

        for (int sz = 1; sz <= n; sz += sz) {
            for (int i = 0; i + sz < n; i += sz + sz) {
                mergeSort(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1));
            }
        }
    }

    public static void sort(Comparable[] arr) {

        int n = arr.length;
        sort(arr, n);
    }

    private static void mergeSort(Comparable[] arr1, int l, int mid , int r) {
        Comparable[] arr2 = Arrays.copyOfRange(arr1, l, r + 1);

        int i = l, j = mid + 1;

        for (int k = l; k <= r; k ++) {
            if (i > mid) {
                arr1[k] = arr2[j - l];
                j++;
            } else if (j > r){
                arr1[k] = arr2[i - l];
                i++;
            } else if (arr2[i - l].compareTo(arr2[j - l]) < 0) {
                arr1[k] = arr2[i - l];
                i++;
            } else {
                arr1[k] = arr2[j - l];
                j++;
            }
        }
    }
}
