package highSort;

import baseSort.Insert;

import java.util.Arrays;

/**
 * 归并排序
 * 将无序数组分成两部分，一直分到一个个体，然后两两合并排序，最后合并排序
 * 时间复杂度O（nlogn)
 */
public class Merge2 {

    private Merge2() {
    }

        public static void main(String[] args){
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8};

        sort(arr);

        for (int i = 0 ; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void mergeSort(Comparable[] arr, Comparable[] aux, int l, int mid , int r) {
        System.arraycopy(arr, l, aux, l, r - l + 1);

        int i = l, j = mid + 1;

        for (int k = l; k <= r; k ++) {
            if (i > mid) {
                arr[k] = aux[j];
                j++;
            } else if (j > r){
                arr[k] = aux[i];
                i++;
            } else if (aux[i].compareTo(aux[j]) < 0) {
                arr[k] = aux[i];
                i++;
            } else {
                arr[k] = aux[j];
                j++;
            }
        }
    }

    private static void sort(Comparable[] arr, Comparable[] aux, int l, int r) {

        if (r - l < 11) {
            Insert.sort(arr, l, r);
            return;
        }

        int mid = (l + r) / 2;
        sort(arr, aux, l, mid);
        sort(arr, aux, mid + 1, r);
        mergeSort(arr, aux, l, mid, r);

    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        Integer[] aux = new Integer[n];
        sort(arr, aux, 0, n - 1);
    }

}
