import java.util.Arrays;
class Arr
{
public static void main(String[] args)
{
 int[][] ar=toMulti(new int[]{1,2},new int[]{1,2,3},new int[]{5,6,7,8});
 System.out.println(Arrays.deepToString(ar));

/*OR You can directly declare 2d array like this if your arrays don't
come as user inputs*/
 int[][] arr={{1,2,3},{1,2},{3,4}};
  System.out.println(Arrays.deepToString(arr));
}    
   /* ... is known as variable argument or ellipsis.
      int[] ... denotes that you can give any number of arguments of the type int[]
      The function input that we get will be in 2d-array int[][].So just return it.*/
   public static int[][] toMulti(int[] ... args) {
    return args;

}
}