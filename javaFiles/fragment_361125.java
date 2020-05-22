import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortMatrixCoordinates
{
    static class Coords
    {
        int x;
        int y;
        Coords(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
        @Override
        public String toString()
        {
            return "("+x+","+y+")";
        }
    }

    public static void main(String[] args)
    {
        runWithSortedMatrix();
        runWithUnsortedMatrix();
    }

    private static void runWithSortedMatrix()
    {
        int labels[][] = new int[][]{
            { 0, 0, 0 },  
            { 1, 1, 1 },  
            { 1, 2, 2 },   
            { 2, 2, 5 } };

        System.out.println("Result with sorted matrix:");
        List<List<Coords>> result = storeValues(labels);
        for (List<Coords> list : result)
        {
            System.out.println(list);
        }
    }

    private static void runWithUnsortedMatrix()
    {
        int labels[][] = new int[][]{
            { 0, 0, 0 },  
            { 3, 3, 3 },  
            { 3, 2, 2 },   
            { 2, 2, 1 } };

        System.out.println("Result with unsorted matrix:");
        List<List<Coords>> result = storeValuesSorting(labels);
        for (List<Coords> list : result)
        {
            System.out.println(list);
        }
    }

    public static List<List<Coords>> storeValues(final int[][] labels)
    {
        List<List<Coords>> result = new ArrayList<List<Coords>>();
        List<Coords> coords = null;
        int previousValue = 0;
        for (int x = 0; x < labels.length; x++) 
        {
            for (int y = 0; y < labels[0].length; y++) 
            {
                int value = labels[x][y];
                if ((x == 0 && y == 0) || previousValue != value)
                {
                    coords = new ArrayList<Coords>();
                    result.add(coords);
                }
                coords.add(new Coords(x,y));
                previousValue = value;
            }
        }
        return result;
    }


    public static List<List<Coords>> storeValuesSorting(final int[][] labels) 
    {
      List<Coords> sortedCoords = new ArrayList<Coords>();
      for (int x = 0; x < labels.length; x++) 
      {
          for (int y = 0; y < labels[0].length; y++) 
          {
              sortedCoords.add(new Coords(x,y));
          }
      }
      Collections.sort(sortedCoords, new Comparator<Coords>()
      {
          @Override
          public int compare(Coords c0, Coords c1)
          {
              int v0 = labels[c0.x][c0.y];
              int v1 = labels[c1.x][c1.y];
              return Integer.compare(v0, v1);
          }

      });
      List<List<Coords>> result = new ArrayList<List<Coords>>();
      List<Coords> coords = null;
      int previousValue = 0;
      for (int i=0; i<sortedCoords.size(); i++) 
      {
          Coords c = sortedCoords.get(i);          
          int value = labels[c.x][c.y];
          if (i == 0 || previousValue != value)
          {
              coords = new ArrayList<Coords>();
              result.add(coords);
          }
          coords.add(c);
          previousValue = value;
      }
      return result;
    }

}