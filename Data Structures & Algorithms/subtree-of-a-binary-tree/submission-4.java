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
    boolean ans;
    boolean isSameHelper(TreeNode p, TreeNode q){
        if(p==null && q==null)
        return true;
        if((p==null && q!=null)||(p!=null && q==null))
        return false;
        if(p.val!=q.val)
        return false;
        return isSameHelper(p.left, q.left) && isSameHelper(p.right, q.right);
    }
    void findSubRoot(TreeNode root, TreeNode subRoot){
        if(root==null || subRoot==null)
        return;
        if(root.val==subRoot.val){
             ans=ans || isSameHelper(root, subRoot);
        }
        findSubRoot(root.left, subRoot);
        findSubRoot(root.right, subRoot);
    } 
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        findSubRoot(root, subRoot);
        return ans;

    }
}
