Scanner in=new Scanner(new FileInputStream ("test.txt"));
/*
 in my text {1 2 3 4 5 6 7 8 9 }
 */
while (in.hasNextInt())
{
    System.out.print(in.nextInt());

}
in=new Scanner(new FileInputStream ("test.txt")); 
while (in.hasNextInt())
{
    System.out.print(in.nextInt());
}