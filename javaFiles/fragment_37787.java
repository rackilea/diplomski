do {
   side1 = in.nextInt();
   side2 = in.nextInt();
   side3 = in.nextInt();

   if ( side1!=0 || side2!=0 || side3!=0 ) {
       if ( side1<=0 || side2<=0 || side3<=0 ) {
          System.out.println("Triangle sides must be positive values.\nPlease enter new values.");
       }
       else if ( side1>=side2+side3 || side2>=side1+side3 || side3>=side2+side1 ) {
          System.out.println("Those sides cannot form a triangle.\nPlease enter new values.");
       }
       else {
           // ... Classify the triangle. 
       }
   }
}
while (side1!=0 || side2!=0 || side3!=0);