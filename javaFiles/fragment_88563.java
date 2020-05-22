int sz = 6;

   for(int d = 1;d<=sz;d++){

    for (int i = d;i <= sz;i++) //for increasing numbers
        System.out.print(i);
    for(int j=sz;j>=d;j--)  //for decreasing numbers
        System.out.print(j);

    System.out.println(); //for newline

    for(int m=0;m<d;m++) // for spaces
        System.out.print(" ");
   }