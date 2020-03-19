package com.zhaoxiang.audition.audition0106;

/**
 * 题目描述：字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
 * 比如，字符串"aabcccccaaa"会变为"a2b1c5a3"。若压缩后的字符串没有变短，则返回原先的字符串。
 * 你可以假设字符串中只包含大小写英文字母（a至z）。
 *
 * Date: 2020-03-16 11:00
 */
public class CompressString {

    public String compressString(String S) {
        // 校验输入字符串长度
        if (S == null || S.length() <= 2) {
            return S;
        }

        // 使用StringBuilder，不要使用字符串+来拼接，会导致大量的内存消耗
        StringBuilder builder = new StringBuilder();
        int count = 1;
        char current = S.charAt(0);
        for (int i = 1; i < S.length(); ++i) {
            if (S.charAt(i) == current) {
                count++;
            } else {
                builder.append(current).append(count);
                current = S.charAt(i);
                count = 1;
            }
        }
        builder.append(current).append(count);
        String result = builder.toString();
        return result.length() < S.length() ? result : S;
    }

    public static void main(String[] args) {

        CompressString cs = new CompressString();
        String result = cs.compressString("abbccd");
        System.out.println(result);
    }
}
