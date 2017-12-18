package sort;

public class Selection {

    public static void main(String args[]) {
        Integer[] parat1 = new Integer[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        sort(parat1, 10);

        for (int i = 0; i < parat1.length; i++) {
            System.out.print(parat1[i] + " ");
        }

        System.out.println();

        Double[] parat2 = new Double[] {4.1, 3.1, 2.1, 1.1};

        sort(parat2, parat2.length);

        for (int i = 0; i < parat2.length; i++) {
            System.out.print(parat2[i] + " ");
        }

        System.out.println();

        String[] parat3 = new String[] {"C", "B", "D", "A"};

        sort(parat3, parat3.length);

        for (int i = 0; i < parat3.length; i++) {
            System.out.print(parat3[i] + " ");
        }

        System.out.println();

        Student[] parat4 = new Student[4];
        parat4[0] = new Student("D", 99);
        parat4[1] = new Student("C", 100);
        parat4[2] = new Student("B", 98);
        parat4[3] = new Student("A", 98);

        sort(parat4, parat4.length);

        for (int i = 0; i < parat4.length; i++) {
            System.out.println(parat4[i] + " ");
        }
    }

    private static void sort(Comparable[] parat, int n) {
        for(int i = 0; i < n; i++) {
            int minIndex = i;
            for(int j = i + 1; j < n; j++) {
                if (parat[j].compareTo(parat[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            swap(i, minIndex, parat);
        }
    }

    private static void swap(int i, int minIndex, Object[] parat) {
        Object a = parat[i];
        parat[i] = parat[minIndex];
        parat[minIndex] = a;
    }

}
