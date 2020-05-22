public static void LoginMenu()
{
    ArrayList<String> hashes = new ArrayList<String>();
    File file = new File("admin.dat");
    try
    {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine())
        {
            hashes.add(scanner.nextLine());
        }
        scanner.close();
    }
    catch (FileNotFoundException exc)
    {
        exc.printStackTrace();
        return;
    }
    Scanner UserPass = new Scanner(System.in);
    while (true)
    {
        System.out.println("Please Enter Your Password: ");
        String UserP = UserPass.nextLine();
        String hashedP = Utility.getHash(UserP);
        if (hashes.contains(hashedP))
        {
            System.out.println("Login Successful.\n");
            AdminMenu();
            break;
        }
        System.out.println("Login Failed!");
    }
}