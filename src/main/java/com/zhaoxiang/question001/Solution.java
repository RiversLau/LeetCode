package com.zhaoxiang.question001;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * 暴力法，直接遍历数组，时间复杂度O(n*n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum_V1(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 一遍Hash表，通过哈希表，利用空间获取时间，时间复杂度O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum_V2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(target - nums[i]) != null) {
                return new int[] {i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        Solution solution = new Solution();
        int[] result = solution.twoSum_V2(nums, target);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }
}
