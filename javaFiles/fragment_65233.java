int[] myArr = new int[10];
    Scanner myScan = new Scanner(System.in);        

    for (int i = 0; i < 10; i++) {
        System.out.println("Enter a value: ");
        myArr[i] = myScan.nextInt();
        myScan.nextLine(); // you need it to consume the "enter"
    }
    System.out.println(Arrays.toString(myArr)); // will print the array