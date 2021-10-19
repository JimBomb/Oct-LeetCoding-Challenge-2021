class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for( int i: nums2){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        int ans[]=new int[nums1.length];
        for( int i =0;i<nums1.length;i++){
            int max=nums1[i];
            for( int j=nums2.length-1;j>=0;j--){
               if(nums1[i]==nums2[j] && j==nums2.length-1){
                   ans[i]=-1; break;
               }
                if(nums2[j]>nums1[i])
                    max=nums2[j];
                if(nums1[i]==nums2[j] && map.get(nums2[j])>0 && max>nums1[i]){
                    map.put(nums2[j], map.get(nums2[j])-1);
                    ans[i]=max;
                    break;
                }
            }
            if(ans[i]==0) ans[i]=-1;
        }
        return ans;
    }
}