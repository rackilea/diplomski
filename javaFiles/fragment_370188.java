class Testing
{
    public static String str1;
    public static String str2;
    public static String str3;
    public static String str4;
    public static String str5;
    public static String str6;

    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a family member's name: ");
        str1 = scanner.next();
        System.out.println("Please enter a family member's name: ");
        str2 = scanner.next();
        System.out.println("Please enter a family member's name: ");
        str3 = scanner.next();
        System.out.println("Please enter a family member's name: ");
        str4 = scanner.next();
        System.out.println("Please enter a family member's name: ");
        str5 = scanner.next();
        System.out.println("Please enter a family member's name: ");
        str6 = scanner.next();

        generateNewName();
    }

    public static void generateNewName()
    {
        System.out.print(str1.charAt(1));
        System.out.print(str2.charAt(1));
        System.out.print(str3.charAt(1));
        System.out.print(str4.charAt(1));
        System.out.print(str5.charAt(1));
        System.out.print(str6.charAt(1));
    }
}