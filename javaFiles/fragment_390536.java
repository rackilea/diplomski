Scanner myInput=new Scanner(System.in);
char ans;

System.out.print("Do you have numbers to compute?");
ans=myInput.findInLine(".").charAt(0);

while ((ans=='Y')||(ans=='y'))
{
    // Code omitted

    System.out.print("Compute another?");
    myInput.nextLine();
    String s = myInput.findInLine(".");
    ans = (null == s) ? 'n' : s.charAt(0);
}