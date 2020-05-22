public class test
{
    public static void main(String[] args) {
     int[] numbers = {2,-1,5,-4,3};
     for(int n : getPositiveNumbers(numbers)){
         System.out.print(n);    
     }


    }
    public static int[] getPositiveNumbers(int[] numbers)
{
    int count = 0;
     for (int n : numbers)
     {
         if(n>0)
         {
            count++;
         }
     }
    int [] nums = new int[count];
    int i =0;
    for (int n : numbers)
    {
        if(n>0)
        {
           nums[i] = n;
           i++;
        }
    }

    return nums;

}
}