import java.util.Arrays;

public class test{
        public static int [] concat (int [] nums1, int [] nums2)
        {
                int length = nums1.length+nums2.length;
                int nums3 [] = new int [length];
                for (int i=0; i<nums1.length; i++)
                {
                        nums3[i] = nums1[i];
                }
                // You can start adding to nums3 where you had finished adding
                // in the previous loop. 
                for (int i=nums1.length; i< nums3.length; i++)
                {
                        // (i - nums1.length) will give you zero initially and 
                        // ends with nums2.length by the time this loop finishes
                        nums3[i]= nums2[i - nums1.length];
                }
                return nums3;

        }

        public static void main(String[] args) {

                int[] temp = {1,2,3,4};
                int[] temp2 = {1,2,3,4};
                System.out.println(Arrays.toString(concat(temp,temp2)));


        }

}