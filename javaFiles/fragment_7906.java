class Num
 {
      public static void main(String args[])
      {
         int input[]={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
         int step = 1;
         for(int i=0;i<input.length;i+=step)
         {
             System.out.println(input[i]);
             step++;
         }
      }
 }