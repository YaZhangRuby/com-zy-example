package com.zy.doc.algorithm;

import java.util.*;

/**
 * Author: zhangya
 * Date: 2019/5/17
 * Time: 18:24
 * Description:
 */
public class 字母异位词分组 {

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map= new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String keyStr = String.valueOf(chars);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<String>());
            map.get(keyStr).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
//        String[] str = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
//        List<List<String>> lists = groupAnagrams(str);
//        String str = "au";
//        int i = lengthOfLongestSubstring(str);
//        System.out.println(i);
        String str1 = "ab";
        String str2 = "eidboaoo";
        boolean b = checkInclusion(str1, str2);
        System.out.println(b);
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length()==0) return 0;
        int result = 1;
        List<String> sublist = new ArrayList<>();
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            result = Math.max(result, sublist.size());
            sublist = new ArrayList<>();
            for (int j = i; j<str.length; j++) {
                char c = str[j];
                if (!sublist.contains(String.valueOf(c))) {
                    sublist.add(String.valueOf(c));
                } else break;
            }
        }
        return result;
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1==null || s2==null || s1.length() == 0 || s2.length() == 0) return false;
        String s11 = new StringBuilder(s1).reverse().toString();
//        List<String> list = new ArrayList<>();
//        for (int i = 0; i< charStr2.length; i++) {
//            if (String.valueOf(charStr2[i]).equals(String.valueOf(charStr1[0]))) {
//                String str = s2.substr(i, s1.length());
//                s2.
//                list.add(str);
//            }
//        }
//        if (list.contains(charStr2)) return true;
//        else return false;
        if (s2.contains(s1) || s2.contains(s11)) return true;
        else return false;
    }
}
