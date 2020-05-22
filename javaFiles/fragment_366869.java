response = stdin.next();
while (!(response.equalsIgnoreCase("Y") || response.equalsIgnoreCase("N")))
{
    System.out.println("Try again, you're still in the loop!");
    response = stdin.next();
}
System.out.println("Congratulations you're out of the loop!");