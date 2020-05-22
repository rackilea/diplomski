Scanner sc=new Scanner(System.in);
int input = 0;
while(true) {
    System.out.println("enter a number");
    if(sc.hasNext("[0-9]+")) {
        input = sc.nextInt();
        break;
    } else {
        System.out.println("not a number, try again");
        sc.next(); // just consume, but ignore as its not a number
    }
}
System.out.println("Entered number is : "+input);