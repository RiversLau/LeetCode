package com.zhaoxiang.question0836;

public class Solution {

    /**
     * 建议通过画图来表明两个矩形可能存在的位置关系
     * @param rec1
     * @param rec2
     * @return
     */
    public boolean isRectangleOverlap_V1(int[] rec1, int[] rec2) {
        boolean flag1 = rec2[0] >= rec1[2] || rec2[2] <= rec1[0];
        boolean flag2 = rec2[1] >= rec1[3] || rec2[3] <= rec1[1];
        if (flag1 || flag2) {
            return false;
        }
        return true;
    }

    /**
     * 如果两个矩形重叠，那么它们重叠的区域一定也是一个矩形，那么这代表了两个矩形与 xx 轴平行的边（水平边）投影到 xx 轴上时会有交集，与 yy 轴平行的边（竖直边）投影到 yy 轴上时也会有交集。
     * 因此，我们可以将问题看作一维线段是否有交集的问题
     * @param rec1
     * @param rec2
     * @return
     */
    public boolean isRectangleOverlap_V2(int[] rec1, int[] rec2) {
        return (Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0])) &&
                (Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]));
    }

    /**
     * 测试用例1：rec1 = [0,0,2,2], rec2 = [1,1,3,3]，结果true
     * 测试用例2：rec1 = [0,0,1,1], rec2 = [1,0,2,1]，结果false
     * 测试用例3：rec1 = [2,17,6,20], rec2 = [3,8,6,20]，结果true
     * 测试用例4：rec1 = [7,8,13,15], rec2 = [10,8,12,20]，结果true
     * @param args
     */
    public static void main(String[] args) {
        int[] rec1 = {7,8,13,15};
        int[] rec2 = {10,8,12,20};
        Solution solution = new Solution();
        boolean result1 = solution.isRectangleOverlap_V1(rec1, rec2);
        System.out.println(result1);

        boolean result2 = solution.isRectangleOverlap_V2(rec1, rec2);
        System.out.println(result2);
    }
}
