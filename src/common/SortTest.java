package common;

import java.lang.reflect.Method;
import java.lang.Class;

public class SortTest {

    private SortTest(){}

    /**
     *生成从lengthL到lengthR之间的数
     * @param n 长度
     * @param lengthL 生成范围左边
     * @param lengthR 生成范围右边
     * @return
     */
    public static Integer[] generate(int n, int lengthL, int lengthR) {
        assert lengthL <= lengthR;

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int)(Math.random() * (lengthR - lengthL + 1) + lengthL);
        }

        return arr;
    }

    //测试排序
    public static void testSort(String name, Comparable[] arr) {

        try {
            Class sortClass = Class.forName(name);

            Method sortMethod = sortClass.getMethod("sort", new Class[]{Comparable[].class});

            long startTime = System.currentTimeMillis();

            Object[] params = new Object[]{arr};

            sortMethod.invoke(null, params);

            long endTime = System.currentTimeMillis();

            assert isSort(arr);

            System.out.println(sortClass + " : " + (endTime - startTime) + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    //检查是否排序成功
    private static boolean isSort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    //生成顺序的数组，然后替换swapTimes个顺序
    public static Integer[] generateNearlyOrderedArray(int n, int swapTimes) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < swapTimes; i++) {
            int a = (int)(Math.random() * n);
            int b = (int)(Math.random() * n);
            int c = arr[a];
            arr[a] = arr[b];
            arr[b] = c;

        }
        return arr;
    }

    public static Integer[] generateOrderedArray( int n ){

        return generateNearlyOrderedArray(n, 0);
    }

    // 生成一个完全逆序的数组
    public static Integer[] generateInversedArray( int n ){

        Integer[] arr = generateOrderedArray( n );
        for( int i = n/2 - 1 ; i >= 0 ; i -- ){
            Integer t = arr[i];
            arr[i] = arr[n-i-1];
            arr[n-i-1] = t;
        }
        return arr;
    }
}
