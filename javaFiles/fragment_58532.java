Scanner scan = new Scanner(System.in);
System.out.println("Enter two numbers");
System.out.println("Separate with spaces");
System.out.println("Code sums from first to second");
int first = scan.nextInt();
int second = scan.nextInt();
int sum = 0;
for(int i = first; i <= second; i++)
{
sum += (i*i);
}