static int findQuadraples(int range)
   {
      int total = 0;

      for (int a = 1; a <= range; a++)
         for (int b = a; b <= range; b++)
            for (int c = b; c <= range; c++)
            {
               int sum = a * a + b * b + c * c;
               int d = isSquare(sum);

               if (d != 0) // a possible Quadruple
               {
                  //System.out.println(Arrays.asList(a, b, c, d));
                  allQuadraples.add(Arrays.asList(a, b, c, d));
                  total++;
               }
            }

      return total;
   }