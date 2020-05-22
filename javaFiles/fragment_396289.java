Scanner sc = new Scanner(System.in);
int number;
do {
System.out.println("Please enter a valid number: ");
while (!sc.hasNextInt()) {
   System.out.println("Error. Please enter a valid number: ");
   sc.next(); 
}
number = sc.nextInt();
} while (!checkChoice(number));

private static boolean checkChoice(int choice){
if (choice <MIN || choice > MAX) {     //Where MIN = 0 and MAX = 20
    System.out.print("Error. ");
    return false;
 }
 return true;
 }