/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    Queue<TreeNode> queue = new ArrayDeque<>();
    void traverseLevel(TreeNode root, List<List<Integer>> finalList) {
        if (root == null)
            return;

        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
           
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null)
                    queue.offer(node.left);

                if (node.right != null)
                    queue.offer(node.right);
            }
            finalList.add(level);
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
       
        List<List<Integer>> finalList = new ArrayList<>();
        traverseLevel(root, finalList);
        return finalList;
    }
}
