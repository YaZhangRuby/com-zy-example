package com.zy.doc.algorithm;

import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * Author: zhangya
 * Date: 2019/4/3
 * Time: 10:17
 * Description:
 */
public class test {

    public static void main(String[] args) {
//        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
//        List<List<String>> lists = groupAnagrams(strs);
        int[][] array = new int[][]{{1}};
        boolean b = searchMatrix(array, 1);
        System.out.println(b);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int n = matrix[0].length - 1;
        for (int[] row : matrix) {
            if (target < row[0]) {
                break;
            }
            if (target > row[n]) {
                continue;
            }
            int val = Arrays.binarySearch(row, target);
            if (val > 0) {
                return true;
            }
        }
        return false;
    }
}
