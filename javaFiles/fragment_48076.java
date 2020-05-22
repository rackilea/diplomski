Scanner input = new Scanner(System.in);
System.out.println("please enter 10 values:");
double myArray[] = new double[10];
int sum = 0;
for (int i = 0; i < myArray.length; i++) {
    myArray[i] = input.nextInt();
    System.out.println("The values are " + myArray[i]);
    sum += myArray[i];
}
System.out.println("The sum of the values is:" + sum);