package com.zhaoxiang.algorithm.question002;

import java.util.ArrayList;

public class Solution {

    /**
     * 自己想出的解决方法，感觉很暴力，代码逻辑也复杂
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers_V1(ListNode l1, ListNode l2) {
        ArrayList<Integer> t1 = new ArrayList();
        while (l1 != null) {
            t1.add(l1.val);
            l1 = l1.next;
        }

        ArrayList<Integer> t2 = new ArrayList<>();
        while (l2 != null) {
            t2.add(l2.val);
            l2 = l2.next;
        }

        ArrayList<Integer> outer = t1.size() >= t2.size() ? t1 : t2;
        ArrayList<Integer> inner = t1.size() >= t2.size() ? t2 : t1;

        int sum;
        for (int i = 0; i < outer.size(); i++) {
            if (i >= inner.size()) {
                outer.set(i, outer.get(i));
            } else {
                sum = outer.get(i) + inner.get(i);
                outer.set(i, sum);
            }
        }

        for (int i = 0; i < outer.size(); i++) {
            if (outer.get(i) >= 10) {
                outer.set(i, outer.get(i) - 10);
                if (i + 1 >= outer.size()) {
                    outer.add(1);
                } else {
                    outer.set(i + 1, outer.get(i + 1) + 1);
                }
            }
        }

        ListNode result = new ListNode(outer.get(0));
        ListNode previous = result;
        for (int i = 1; i < outer.size(); i++) {
            ListNode current = new ListNode(outer.get(i));
            previous.next = current;
            previous = current;
        }

        return result;
    }

    /**
     * 官方方法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers_V2(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, current = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;

            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;

            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(9);
        ListNode l12 = new ListNode(9);
//        ListNode l123 = new ListNode(3);
//        l12.next = l123;
        l1.next = l12;

        ListNode l2 = new ListNode(9);
//        ListNode l22 = new ListNode(6);
//        ListNode l23 = new ListNode(4);
//        l2.next = l22;
//        l22.next = l23;

        Solution solution = new Solution();
        ListNode result1 = solution.addTwoNumbers_V1(l1, l2);

        ListNode result2 = solution.addTwoNumbers_V2(l1, l2);
    }
}
