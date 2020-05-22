public static void main ( String args[] )
{ 
  double[] nums  = {126, 12.939, 795, 320.16,
             110, 34.7676, 7773, 67, 567, 323};
  double[] squares = square(nums);

  for(int i = 0; i < nums.length ; i++ )
    System.out.println ("Square root of " + nums[i] + " is " + squares[i]);
}