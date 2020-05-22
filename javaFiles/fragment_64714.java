public class Main
{
   public static final int ROW_COUNT = 5;
   public static final int COL_COUNT = 10;

   public static void main(String[] args)
   {
      ArrayList<ArrayList<Double>> grades = new ArrayList<ArrayList<Double>>();

      for (int i = 0; i < ROW_COUNT; i++)
      {
         ArrayList<Double> row = new ArrayList<Double>();

         for (int j = 0; j < COL_COUNT; j++)
         {
            row.add(100.0 - j - i);
         }

         grades.add(row);
      }

      for (int i = 0; i < ROW_COUNT; i++)
      {
         for (int j = 0; j < COL_COUNT; j++)
         {
            System.out.print(grades.get(i).get(j));
            System.out.print(", ");
         }

         System.out.println("");
      }
   }
}