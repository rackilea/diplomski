int digit;
Scanner input = new Scanner(System.in);

do {
    System.out.println("Enter a positive integer: ");
    digit = input.nextInt();
} while (digit <= 0);
input.close();

String sdigit = digit + "";
int sum=0;       

for (int i = 0; i < sdigit.length(); i++){
    System.out.println(sdigit.charAt(i));
    sum = sum + (sdigit.charAt(i) - '0');
}

System.out.println("Sum is : "+sum);