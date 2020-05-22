public static void main(String[] args) {

Scanner input = new Scanner(System.in);
int n = 3;
int[] numbers = new int[n];
float total = 0;

for (int i = 0; i <= 2; i++) {
int row=i+1;
    System.out.println("Please type the number " + row + ":");
    numbers[i] = input.nextInt();

    total = total + numbers[i];

}

System.out.println("The average of the 3 number is: " + total / n);
}