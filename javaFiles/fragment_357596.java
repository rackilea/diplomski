boolean repeat = false;

    int[] array = new int[9];

    for(int i=0 ; i<9 && repeat!=true ; i++)//checks for repeated input
    {
      System.out.println("Enter a number 1 - 9");
      int num = scan.nextInt();               
      array[i] = num;

       for(int j=0; j<i; j++)
       {
          if(num==array[j])
          {
             repeat = true;
             break; //breaks out of the loop if encounters a repeated input
           }
        }
    }

if(repeat)
  System.out.println("No Duplicates Allowed!");