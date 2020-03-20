package com.zhaoxiang.audition.audition0040;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("arr不能为空");
        }
        if (k > arr.length) {
            throw new IllegalArgumentException("数组长度不满足，无法返回");
        }
        Arrays.sort(arr);

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 1};
        int k = 1;
        Solution solution = new Solution();
        int[] result = solution.getLeastNumbers(arr, k);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
