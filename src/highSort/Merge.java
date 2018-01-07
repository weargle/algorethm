package highSort;

import baseSort.Insert;

import java.util.Arrays;

/**
 * 归并排序
 * 将无序数组分成两部分，一直分到一个个体，然后两两合并排序，最后合并排序
 * 时间复杂度O（nlogn)
 */
public class Merge {

    private Merge() {
    }

        public static void main(String[] args){
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8};

        sort(arr);

        for (int i = 0 ; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
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

    private static void sort(Comparable[] arr, int l, int r) {

//        if (l >= r) {
//            return;
//        }

        if (r - l < 11) {
            Insert.sort(arr, l, r);
            return;
        }

        int mid = (l + r) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        mergeSort(arr, l, mid, r);

    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

}
