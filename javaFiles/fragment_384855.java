Scanner in = new Scanner(System.in);

int currentMax = 0;
int number = 0;
do {
   System.out.println("Enter a number: ");
   number = in.nextInt();
   if(number > currentMax) {
      currentMax = number;
      System.out.println("Max number is: " + currentMax);
   }
} while(number > 0);