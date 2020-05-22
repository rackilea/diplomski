Scanner in = new Scanner(System.in);

int userIn = -1;

try {
    userIn = in.nextInt();
}

catch (InputMismatchException a) {
    System.out.print("Problem");
}

switch(userIn){
case -1:
    //You didn't have a valid input
    break;