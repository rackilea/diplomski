int number, total=0;
    int i = 1;
    Scanner sc = new Scanner(System.in);
    while (i<=10)
    {   
          System.out.print("Enter Grade "+i+" : \n");
          number = sc.nextInt();
          if (number < 100){
               total = total + number;
               i++;
          }else{
                 System.out.println("invalid value");
          }
    }