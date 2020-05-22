String input = "1,2,3";
Scanner scn = new Scanner(input);  // Scanner also accepts a file!
scn.useDelimiter(","); // Since the integers are "comma" separated.
while(scn.hasNext())
{
    System.out.println(scn.nextInt()); // here you can store your integers back into your array
}
scn.close();