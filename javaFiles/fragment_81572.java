import java.util.ArrayList;
import java.util.List;

public class ListOfLists {

  public static void main(String args[]) {
    List<List<Integer>> listOfLists = new ArrayList<List<Integer>>();

    List<Integer> aList = new ArrayList<Integer>();
    List<Integer> bList = new ArrayList<Integer>();
    List<Integer> cList = new ArrayList<Integer>();
    List<Integer> dList = new ArrayList<Integer>();

    aList.add(0);
    bList.add(1); bList.add(2);
    cList.add(3); cList.add(4); cList.add(5);
    dList.add(6); dList.add(7); dList.add(8); dList.add(9);

    listOfLists.add(aList);
    listOfLists.add(bList);
    listOfLists.add(cList);
    listOfLists.add(dList);

    for (List<Integer> list : listOfLists) {
      for (Integer i : list) {
        System.out.print(i + "\t");
      }
      System.out.println();
    }
  }
}