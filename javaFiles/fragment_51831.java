public static void main(String[] args)
{
    Name name = getName();
    String first = name.firstName;
    String last = name.lastName;
}

public static Name getName()
{
    Scanner x = new Scanner(System.in);

    System.out.print("Please enter your first name: ");
    String firstName = x.nextLine();

    System.out.print("\nPlease enter your last name: ");
    String lastName = x.nextLine();

    return new Name(firstName, lastName);
}