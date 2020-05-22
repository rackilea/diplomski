String s1 = "Y";
do
{
    System.out.println("Do you want to continue? Y/N");
    s1 = scan.nextLine();
}while(s1.equalsIgnoreCase("Y"));