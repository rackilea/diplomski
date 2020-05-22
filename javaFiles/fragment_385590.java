Scanner input= new Scanner(System.in);
    System.out.println("Enter the number of months :");
    int month = input.nextInt();
    if(month<0)
    {
            System.out.println("Invalid Input");
    }else{
    int sum = 0;
    int a[] = new int[month];
    System.out.println("Enter the profit of each month in shipment");
    for (int i=0; i<month; i++)
    {
        a[i] = input.nextInt();
        sum = sum+a[i];
    }
      System.out.println("Total profit : "+sum);
    }