package com.zy.doc.algorithm;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Author: zhangya
 * Date: 2019/5/20
 * Time: 17:19
 * Description:
 * 树有三种排序方式：前序、中序和后序
 * 前序：根、左、右
 * 中序：左、根、右（有序数组）
 * 后序：左、右、根
 * /**
 *  * Definition for a binary tree node.
 *  * public class TreeNode {
 *  *     int val;
 *  *     TreeNode left;
 *  *     TreeNode right;
 *  *     TreeNode(int x) { val = x; }
 *  * }
 *  */
public class 二叉树遍历 {

    //先序
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        Stack<TreeNode> stack = new Stack<>();
//        while (root != null || !stack.isEmpty()) {
//            if (root != null) {
//                stack.push(root);
//                root = root.left;
//            } else {
//                root = stack.pop();
//                result.add(root.val);
//                root = root.right;
//            }
//        }
//        return result;
//
//    }
//
//    //中序
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode node = root;
//        while (root != null || !stack.isEmpty()) {
//            while (node != null) {
//                stack.push(node);
//                node = node.left;
//            }
//            if (!stack.isEmpty()) {
//                node = stack.pop();
//                result.add(node.val);
//                node = node.right;
//            }
//        }
//        return result;
//
//    }
}
