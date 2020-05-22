import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Niz
{

  public static void main(String[] args)
  {
    int[] array = {12, 23, -22, 0, 43, 545, -4, -55, 43, 12, 0, -999, -87};

    List<Integer> array1 = new ArrayList<Integer>();
    List<Integer> array2 = new ArrayList<Integer>();

    for (int i = 0; i < array.length; i++)
      if (array[i] < 0)
        array1.add(array[i]);
      else
        array2.add(array[i]);

    HashSet<Integer> notDupes = new HashSet<Integer>();
    HashSet<Integer> duplicates = new HashSet<Integer>();
    for (int i = 0; i < array.length; i++)
    {
      if (!notDupes.contains(array[i]))
      {
        notDupes.add(array[i]);
        continue;
      }
      duplicates.add(array[i]);

    }

    System.out.println("negative members of the array: " + array1);
    System.out.println("positive members of the array : " + array2);
    System.out.println("number of duplicates : " + duplicates.size());

  }

}