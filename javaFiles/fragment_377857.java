public static void Operation(int response)
{
    int digit1 = getNumber();
    int digit2 = getNumber();
    switch(response)
    {
        case 1: add(digit1, digit2); break;
        case 2: subtract(digit1,digit2); break;
        case 3: multiply(digit1,digit2); break;
        case 4: divide(digit1,digit2); break;
        default: System.out.println("Invalid Response");
    }
}
public static int getNumber()
{
    try
    {
        SecureRandom num = SecureRandom.getInstance("SHA1PRNG");
        return num.nextInt();
    }
    catch(NoSuchAlgorithmException nsae)
    {
        System.out.println("Is SHA1PRNG spelled correctly?");
        return 0;
    }
}