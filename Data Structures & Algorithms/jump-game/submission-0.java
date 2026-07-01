class Solution {
    public boolean canJump(int[] nums) {
        int sum=0;
        int goal=0;
        for(int i=0;i<nums.length;i++){
            if(goal>=i){
                goal=Math.max(goal, i+nums[i]);
            }
            else
            return false;
        }
        if(goal>=nums.length-1)
        return true;
        return false;
        
    }
}
