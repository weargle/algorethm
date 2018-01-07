package highSort;

public class ListMerge {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(8);
        ListNode node = new ListNode(5);
        listNode.next = node;
        ListNode list = new ListNode(4);
        node.next = list;
        ListNode list1 = new ListNode(7);
        list.next = list1;

        int n = length(listNode);
        sort(listNode);

        while (listNode != null) {
            System.out.print(listNode.data);
            listNode = listNode.next;
        }

    }

    public static ListNode getMiddle(ListNode listNode) {
        if (listNode.next == null) {
            return listNode;
        }

        ListNode slow, fast;
        slow = fast = listNode;

        if (slow.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void merge(ListNode ...values) {

        ListNode listNode = values[0], list1 = values[1],
                midList = values[2], list2 = values[3];
        ListNode list = new ListNode(0);

                if (list1.next == null) {
                    list.data = midList.data;
                    list1 = list1.next;
                } else if (list2.next == null) {
                    list.data = list2.data;
                    list2 = list2.next;
                } else if (list1.data < list2.data) {
                    list.data = list1.data;
                    list1 = list1.next;
                } else {
                    list.data = list2.data;
                    list2 = list2.next;
                }
                list = list.next;

    }

    private static int length(ListNode listNode) {
        int length = 1;
        while (listNode.next != null) {
            length++;
            listNode = listNode.next;
        }

        return length;
    }

    private static void sort(ListNode listNode, int n) {

        ListNode list1, list2, midList;
        for (int sz = 1; sz <= n; sz += sz) {
            list1 = listNode;
            list2 = listNode.next;
            midList = listNode.next;

            for (int i = 0; i + sz < n; i += sz + sz) {
                merge(listNode, list1, midList, list2);
            }
            listNode = listNode.next;
        }
    }

    public static void sort(ListNode listNode) {

    int n = length(listNode);
        sort(listNode, n);
    }

}
