public int fill() {

    System.out.println("enter the number");
    Scanner in = new Scanner(System.in);
    num = in.nextInt();

    if (num < 0) {
        System.out.println("enter a positive number");
    }
    int myNumber = num;  
    while (myNumber != 0) {
        reverse = reverse * 10;
        reverse = reverse + myNumber % 10;
        myNumber = myNumber / 10;
    }
    System.out.println("your reverse number is : " + reverse);
    return num;
}

OUTPUT:
enter the number
1234
your reverse number is : 4321
sum of digits: 10