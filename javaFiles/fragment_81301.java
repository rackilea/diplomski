while (iInput != -1 ) {
   System.out.println( "Enter a homework grade. Press -1 when finished" );
   iInput = dylan.nextInt();

   if(iInput != -1)
      iTotalGrades += iInput;
   }
}