System.out.println("Welcome to BlackJack 21!");
Scanner data= new Scanner(System.in);
int num1 = 0, num2 = 0;
// Read 1st number
System.out.println("Enter 1st number");
num1=data.nextInt();
// Read 2nd number
System.out.println("Enter 2nd number");
num2=data.nextInt();
// Find largest number
if(num1>num2) {
    System.out.println("The largest number:"+num1);
} else {
    System.out.println("The largest number:"+num2); 
}
// If a number is too large
if(num1 > 21 || num2 > 21) {
    // Your Code
}