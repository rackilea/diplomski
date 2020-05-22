int number = -1;

System.out.println("Please enter an integer that shows the " + 
  "number of times to print \"Hello World\" : ");
//store count
if (scan.hasNextInt()) number = scan.nextInt();

if (number != -1) System.out.print("Your integer is " + number);