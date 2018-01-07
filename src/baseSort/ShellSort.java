package baseSort;

public class ShellSort {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{49, 38, 65, 97, 26, 13, 27, 49, 55, 4};
        long startTime = System.currentTimeMillis();
        sort(arr);
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println(time);
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        int h = 1;
        while (h < n/3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < n; i++) {
                Comparable e = arr[i];
                int j = i;
                for (;j >= h && e.compareTo(arr[j - h]) < 0;) {
                    arr[j] = arr[j - h];
                    j -= h;
                }

                arr[j] = e;
            }

            h = h / 3;
        }

    }
}
