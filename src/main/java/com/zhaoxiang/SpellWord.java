package com.zhaoxiang;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 * 注意：每次拼写时，chars 中的每个字母都只能用一次，返回词汇表 words 中你掌握的所有单词的 长度之和。
 *
 * Date: 2020-03-17 16:00
 */
public class SpellWord {

    /**
     * 自己想到的解决思路
     * @param words
     * @param chars
     * @return
     */
    public int spellWord_V1(String[] words, String chars) {

        if (words == null || words.length == 0) {
            return 0;
        }
        if (chars == null || chars.length() == 0) {
            return 0;
        }

        Map<Character, Integer> letterMap = new HashMap();
        for (char ch : chars.toCharArray()) {
            if (!letterMap.containsKey(ch)) {
                letterMap.put(ch, 1);
            } else {
                letterMap.put(ch, letterMap.get(ch) + 1);
            }
        }

        char[] wordChars;
        Map<Character, Integer> wordMap = new HashMap();
        int index;

        int result = 0;
        for (String word : words) {
            index = 0;
            wordMap.clear();
            wordChars = word.toCharArray();
            for (char ch : wordChars) {
                if (!wordMap.containsKey(ch)) {
                    wordMap.put(ch, 1);
                } else {
                    wordMap.put(ch, wordMap.get(ch) + 1);
                }
            }

            for (char ch : wordMap.keySet()) {
                index++;
                if (!letterMap.containsKey(ch) || letterMap.get(ch).intValue() < wordMap.get(ch).intValue()) {
                    break;
                }
                if (index == wordMap.keySet().size()) {
                    result += word.length();
                }
            }
        }

        return result;
    }

    /**
     * LeetCode其他用户提交的方法
     * @param words
     * @param chars
     */
    public int spellWord_V2(String[] words, String chars) {

        // 因为26个字母从a开始，减去a，那么a就在角标0，b在角标1，以此类推，默认int[]数组值为0，值为多少就代表出现几次
        int[] charValue = new int[26];
        for (char ch : chars.toCharArray()) {
            charValue[ch - 'a']++;
        }

        int result = 0;
        boolean flag;
        for (String word : words) {
            flag = true;
            // 下述步骤同处理字母表一致
            int[] temp = new int[26];
            for (char ch : word.toCharArray()) {
                temp[ch - 'a']++;
            }

            // 判断相同位置的字母表与单词的次数，如果单词的次数大于字母次数，一定是不可以的。
            for (int i = 0; i < charValue.length; i++) {
                if (charValue[i] < temp[i]) {
                    flag = false;
                    break;
                }
            }

            // 通过标识flag来判断是否整个单词都能拼写完成，可以的话算入总长度
            if (flag) {
                result += word.length();
            }
        }

        return result;
    }

    public static void main(String[] args) {

        SpellWord spellWord = new SpellWord();

        String[] words = {"hello", "world", "leetcode"};
        String chars = "welldonehoneyr";

        Long now = System.currentTimeMillis();
        int result1 = spellWord.spellWord_V1(words, chars);
        System.out.println(result1 + ", 耗时：" + (System.currentTimeMillis() - now) + "ms");

        now = System.currentTimeMillis();
        int result2 = spellWord.spellWord_V2(words, chars);
        System.out.println(result2 + ", 耗时：" + (System.currentTimeMillis() - now) + "ms");
    }
}
