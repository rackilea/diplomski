import java.util.HashSet;
import java.util.HashSet;

public class HelloWorld
{
  public static void main(String[] args)
  {
    int[][] arr = {
      {2 , 6 , 46, 8 , 7 , 25, 64 , 9 , 10},
      {6 , 10, 50, 12, 11, 29, 68 , 13, 14},
      {46, 50, 90, 52, 51, 69, 108, 53, 54}
    };

    HashSet<Integer> elements = new HashSet<>();
    HashSet<Integer> duplicates = new HashSet<>();
    for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr[i].length; j++) {
            if(elements.contains(arr[i][j])) {
                duplicates.add(arr[i][j]);
            }
            elements.add(arr[i][j]);
        }
    }

    System.out.println(duplicates.toString());
  }
}