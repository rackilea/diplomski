1 public static int[] multiply(int[] children, int number)
2 {
3     int array[] = new int[children.length];
4     for( int i = 0; i < children.length; i++)
5     {
6         array[i] = children[i] * number;
7     }//end for
8     return array;
9 }