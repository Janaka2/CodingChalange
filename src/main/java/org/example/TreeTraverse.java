package org.example;

import java.util.HashSet;
import java.util.Set;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class TreeTraverse {
    public static TreeNode[] findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        TreeNode[] result = new TreeNode[2];
        dfs(root, k, set, result);
        return result;
    }

    public static boolean dfs(TreeNode root, int k, Set<Integer> set, TreeNode[] result) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            result[0] = new TreeNode(k - root.val);
            result[1] = root;
            return true;
        }
        set.add(root.val);
        return dfs(root.left, k, set, result) || dfs(root.right, k, set, result);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(15);

        TreeNode[] result = findTarget(root, 20);
        System.out.println("Nodes found: " + result[0].val + ", " + result[1].val);
    }
}

//    This problem was asked by Dropbox.
//
//        Given the root to a binary search tree, find the second largest node in the tree.
