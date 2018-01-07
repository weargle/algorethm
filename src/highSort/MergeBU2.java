package highSort;

/**
 * 自底向上的归并排除
 */
public class MergeBU2 {

    public MergeBU2() {
    }

    private static void sort(Comparable[] arr, int n) {

        Integer[] aux = new Integer[n];

        for (int sz = 1; sz <= n; sz += sz) {
            for (int i = 0; i + sz < n; i += sz + sz) {
                mergeSort(arr, aux, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1));
            }
        }
    }

    public static void sort(Comparable[] arr) {

        int n = arr.length;
        sort(arr, n);
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
}
