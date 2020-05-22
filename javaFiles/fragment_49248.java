for (int number = 0; number < 10000; number++) {
     boolean isFourDifferent = false;
     boolean isThousand3TimesTens = false;
     boolean isOdd = false;
     boolean is27 = false;

     int temp = number;
     int d0 = temp % 10; temp /=10;
     int d1 = temp % 10; temp /=10;
     int d2 = temp % 10; temp /=10;
     int d3 = temp;

     if ((d0 != d1) && (d0 != d2) && (d0 !=d3) &&
             (d1 != d2) && (d1 != d3) && 
             (d2 != d3))
         isFourDifferent = true;

     if (d3 == (3 * d1))
         isThousand3TimesTens = true;

     if (d0 % 2 != 0)
         isOdd = true;

     if ((d0 + d1 + d2 + d3) == 27)
         is27 = true;

     if(isFourDifferent  && isThousand3TimesTens && isOdd && is27)
         System.out.println("Found" + number);
 }