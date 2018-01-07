package highSort;

import baseSort.Insert;

import java.util.Random;

/**
 * 三路快速排序
 */
public class Quick3Ways {

    public static void main(String[] args) {
        int n = 100000;
        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Random().nextInt(1000);
        }

        long start = System.currentTimeMillis();
        sort(arr);
        long end = System.currentTimeMillis();

        long time  = end - start;

        System.out.println();
        System.out.print(time);
    }

    public static void sort(Comparable[] arr) {

        int n = arr.length;

        sort(arr, 0, n - 1);
    }

    // 递归使用快速排序,对arr[l...r]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r) {

        //当数组小于一定规模，使用插入排序
        if (r - l < 11) {
            Insert.sort(arr, l, r);
            return;
        }

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap(arr, l, (int)(Math.random() * (r - l + 1)) + l);

        Comparable t = arr[l];

        int lt = l + 1;
        int gt = r + 1;
        int i = l + 1;

        while (i < gt) {
            if (arr[i].compareTo(t) < 0) {
                swap(arr, i, lt);
                i++;
                lt++;
            } else if (arr[i].compareTo(t) > 0) {
                swap(arr, i, gt - 1);
                gt--;
            } else {
                i++;
            }
        }

        swap(arr, l, lt);

        sort(arr, l, lt - 1);
        sort(arr, gt, r);
    }


    private static void swap(Comparable[] arr, int l, int j) {

        Comparable a = arr[j];
        arr[j] = arr[l];
        arr[l] = a;
    }
}
