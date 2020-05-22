boolean failed = true;
while (scanner.hasNextLine())
{
    String fileline = scanner.nextLine();
    if (fileline.equals(hashedP))
    {
        failed = false;
        System.out.println("Login Successful.\n");
        AdminMenu();
    }
}
if(failed)
{
    System.out.println("Login Failed!");
    LoginMenu();
}