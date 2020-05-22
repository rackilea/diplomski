import java.util.Random;

public class Program {

    public static void main(String[] args) 
    {
        int[] nums = new int[100];

        for(int i = 0; i < nums.length; ++i) 
        {
            nums[i] = i + 1;
        }

        Random generator = new Random();
        for(int i = 0; i < nums.length; ++i) 
        {           
            int j = generator.nextInt(nums.length - i);         
            int tmp = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = nums[j];
            nums[j] = tmp;
        }
    }

}