public class Area_Shapes {
   public Area_Shapes(int shape, double l1, double l2)
   {
      double area;
      switch (shape) {
        case 1:
         area = (l1 * l2) / 2;
          System.out.println("A triangle has an area of: " + area);
          break;

       ...
      }
   }
}