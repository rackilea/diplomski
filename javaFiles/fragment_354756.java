...
loop = true;
System.out.println("Enter how many numbers to Subtract?: ");
n = s.nextInt();
System.out.println("Enter number 1 : ");
int sum = s.nextInt();
for (int i=2; i <= n; i++) {
    try {
        System.out.println("Enter number " + i + " : ");
        a = s.nextInt();
        sum -= a;
    } catch (Exception e) {
        System.out.println("Invalid Entry. Try again!!");
    }
}
...