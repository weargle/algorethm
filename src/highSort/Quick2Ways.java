package highSort;

import baseSort.Insert;
import common.SortTest;

/**
 * 二路快速排序
 */
public class Quick2Ways {

    public static void main(String[] args) {
        // 双路快速排序算法也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int n = 100000;
        Integer[] arr = SortTest.generate(n, 0 , 10);

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

    // 递归使用快速排序,对arr[l...r]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r) {

        // 对于小规模数组, 使用插入排序
        if (r - l < 11) {
            Insert.sort(arr, l, r);
            return;
        }

        int p = partition(arr, l, r);

        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    // 双路快速排序的partition
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    public static int partition(Comparable[] arr, int l, int r) {

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap(arr, l, (int)(Math.random() * (r - l + 1)) + l);
        Comparable t = arr[l];
        int i = l + 1, j = r;

        while (true) {
            // 注意这里的边界, arr[i].compareTo(v) < 0, 不能是arr[i].compareTo(v) <= 0
            //防止出现一边多一边少
            while (i <= r && arr[i].compareTo(t) < 0) {
                i++;
            }
            while (j >= l + 1 && arr[j].compareTo(t) > 0) {
                j--;
            }

            if (i > j) {
                break;
            }
            swap(arr, i, j);
            i++;
            j--;

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
