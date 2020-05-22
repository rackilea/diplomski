public static int getInt() throws IOException
{
    int a = 0;
    System.out.println("Enter an interger: ");
    Scanner input = new Scanner(System.in);
    try {
        a = input.nextInt();
    } catch (InputMismatchException ime) {
        throw new IOException("Could not get int from input", ime);
    }
    return a;
}