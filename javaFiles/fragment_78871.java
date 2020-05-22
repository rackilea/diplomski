import java.util.*;

class Compare2DArray implements Comparator {
  public int compare(Object a, Object b) {
    int aa[] = (int[]) a;
    int bb[] = (int[]) b;
    for (int i = 0; i < aa.length && i < bb.length; i++)
      if (aa[i] != bb[i])
        return aa[i] - bb[i];
    return aa.length - bb.length;
  }
}

class sort2d {
  public static void main(String args[]) {
    int d2 [][] = {{1,43},{26,98},{44,398},{11,34},{17,32}};
    Arrays.sort(d2, new Compare2DArray());
    for (int i = 0; i < d2.length; i++) {
      for (int j = 0; j < d2[i].length; j++)
        System.out.print(d2[i][j] + " ");
      System.out.println();
    }
  }
}