Scanner scan = new Scanner(System.in);

System.out.println("Please Type a number no smaller than 2");
int inputNumber = scan.nextInt();

while(inputNumber < 2){
    System.out.println("you need a number greater than or equal to 2, try again");
    inputNumber = scan.nextInt();
}

System.out.println(inputNumber);