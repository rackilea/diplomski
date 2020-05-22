Scanner scan = new Scanner(System.in);
System.out.println("Enter 3 digits:");

int sum=0;
for(int i=0;i<3;i++){
    sum = sum + scan.nextInt();
}
System.out.println(sum);