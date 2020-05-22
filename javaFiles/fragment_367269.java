public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = null;

        for(int i=0;i<nums.length;i++) {
            int value = nums[i];

            for(int j=i+1;j<nums.length;j++) {
                int x=nums[j];
                if ((value+x)==target) {
                    answer = new int[2]; 
                    answer[0]=i;
                    answer[1]=j; 
                }
            }
        }

        System.out.println("leet method executed");

        if (answer == null) {
            return nums;
        }

        return answer;
    }
}