int[] values = { 1, 2, 5, 5, 3, 1, 2, 4, 3, 2, 2, 2, 2, 3, 6, 5, 5, 6, 3, 1 };

 boolean inRun = false;

 for (int i = 0; i < values.length; i++) {

     if (i + 1 < values.length && values[i] == values[i + 1] )
     {
         System.out.print("(");
         while (i + 1 < values.length && values[i] == values[i + 1] )
         {
             System.out.print(values[i++]);
         }
         System.out.print(values[i++]);
         System.out.print(")");
     }
     System.out.print(values[i]);

 }