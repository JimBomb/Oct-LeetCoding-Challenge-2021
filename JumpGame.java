class Solution {
   //method 1 memoization
    public boolean canJump1(int[] nums) { 
        int n=nums.length;
        Boolean[] dp=new Boolean[n];
        
        return can(nums,0,n-1,dp);
         
    }
     
    boolean can(int[] n,int i,int f,Boolean[] dp){
        if(i>f) return false;
        if(i==f) return true;
        if(dp[i]!=null) return dp[i];
        Boolean ispos=false;
        for(int jump=1;jump<=n[i];jump++){
            ispos =ispos || can(n,i+jump,f,dp);
        }
        return dp[i]=ispos;
    }
    // method 2 DP
   public boolean canJump(int[] nums) { 
       int n=nums.length;
       boolean[] dp=new boolean[n];
       dp[n-1]=true;
       for(int i=n-2;i>=0;i--){
           boolean b=false;
           for(int j=i+1;j<=i+nums[i] && j<n ;j++){
                b= (b || dp[j]);
           }
           dp[i]=b;
       }
       return dp[0];
   }
  
}
