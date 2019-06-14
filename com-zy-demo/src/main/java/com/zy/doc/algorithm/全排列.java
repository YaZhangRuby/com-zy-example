package com.zy.doc.algorithm;

/**
 * Author: zhangya
 * Date: 2019/5/17
 * Time: 18:18
 * Description:
 */
public class 全排列 {

    public static void permutation(char[]ss, int start){
        if (ss == null || start < 0 || start > ss.length) {
            return;
        }

        if (start == ss.length-1) {
            System.out.println(new String(ss));
        } else {
            for(int j = start; j<ss.length; j++) {
                char temp = ss[j];   //交换前缀,使之产生下一个前缀
                ss[j] = ss[start];
                ss[start] = temp;
                permutation(ss,start+1);
                temp = ss[start];  //将前缀换回来,继续做上一个的前缀排列
                ss[j] = ss[start];
                ss[start] = temp;
            }
        }
    }

    public static void main(String args[]){
        permutation(new char[]{'a','b','c','d'},0);
    }
}
