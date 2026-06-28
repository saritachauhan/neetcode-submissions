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
    List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();
    public List<TreeNode> findNode(TreeNode root, TreeNode node, List<TreeNode> list) {
        if (root == null)
            return list;
        else if (root.val == node.val){
         list.add(root);
            return list;
        }
        else if (root.val > node.val) {
            list.add(root);
            findNode(root.left, node, list);
        } else {
            list.add(root);
            findNode(root.right, node, list);
        }
        return list;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        TreeNode dummy = new TreeNode(-1); 
        path1=findNode(root, p, path1);
        path2=findNode(root, q, path2);
        int i = 0;
        while (i < path1.size() && i < path2.size()) {
            System.out.println(path1.get(i).val);
            if (path1.get(i).val != path2.get(i).val)
                return path1.get(i - 1);
                i++;
        }
        if(i+1<path1.size())
        return path1.get(i-1);
        else
        return path2.get(i-1);
    }
}
