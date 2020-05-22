Scanner scan = new Scanner(System.in);
int sum = 0;
while(scan.hasNextInt())
{
    int a = scan.nextInt();
    sum = sum + a;
}
System.out.println(sum);