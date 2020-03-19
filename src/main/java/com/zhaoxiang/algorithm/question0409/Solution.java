package com.zhaoxiang.algorithm.question0409;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestPalindrome_V1(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            if (countMap.containsKey(ch)) {
                countMap.put(ch, countMap.get(ch) + 1);
            } else {
                countMap.put(ch, 1);
            }
        }

        int longestOdd = 0;
        int evenLength = 0;
        boolean hasOdd = false;
        for (Character ch : countMap.keySet()) {
            if (countMap.get(ch) % 2 == 0) {
                evenLength += countMap.get(ch);
                continue;
            }
            if (countMap.get(ch) % 2 == 1) {
                longestOdd += countMap.get(ch) - 1;
                hasOdd = true;
            }
        }

        return hasOdd ? evenLength + longestOdd + 1 : evenLength + longestOdd;
    }

    public int longestPalindrome_V2(String s) {

        int[] count = new int[128];
        for (char ch : s.toCharArray()) {
            count[ch]++;
        }

        int ans = 0;
        for (int v : count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String str = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        Solution solution = new Solution();
        int result1 = solution.longestPalindrome_V1(str);
        System.out.println(result1);

        int result2 = solution.longestPalindrome_V2(str);
        System.out.println(result2);
    }
}
