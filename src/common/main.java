package common;

import java.util.Arrays;

public class main {

    private main(){}

    public static void main(String[] args) {

        int n = 1000000;
        Integer[] arr1 = SortTest.generate(n, 0, n);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr5 = Arrays.copyOf(arr1, arr1.length);

//        Integer[] arr = SortTest.genrateNearlyOrderArray(n, 3);
//        Integer[] arr2 = arr;

//        SortTest.testSort("baseSort.Insert", arr);
//
//        SortTest.testSort("baseSort.Selection", arr2);
//
//        SortTest.testSort("baseSort.ShellSort", arr2);

        SortTest.testSort("highSort.Merge", arr3);
//        SortTest.testSort("highSort.Merge2", arr);

        SortTest.testSort("highSort.MergeBU", arr1);
//        SortTest.testSort("highSort.MergeBU2", arr2);

//        SortTest.testSort("highSort.Quick", arr2);
//        SortTest.testSort("highSort.Quick2Ways", arr4);
//        SortTest.testSort("highSort.Quick3Ways", arr5);
    }

}
