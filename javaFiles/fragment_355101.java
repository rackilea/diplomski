public static void main(String[] args)
{
    String[] testStrings = {"abcdefghijklmnopqrstuvwxyz0123456789", "", "00000", "abcdefghijklmnopqrstuvwxyz0123456789&", "1", "q", "test123", "(#*$))&v", "ABC123", "hello", "supercalifragilisticexpialidocious"};

    long startNanos = System.nanoTime();

    for (String testString: testStrings)
    {
        isAlphaNumericOriginal(testString);
    }

    System.out.println("Time for isAlphaNumericOriginal: " + (System.nanoTime() - startNanos) + " ns"); 

    startNanos = System.nanoTime();

    for (String testString: testStrings)
    {
        isAlphaNumericFast(testString);
    }

    System.out.println("Time for isAlphaNumericFast: " + (System.nanoTime() - startNanos) + " ns");

    startNanos = System.nanoTime();

    for (String testString: testStrings)
    {
        isAlphaNumericRegEx(testString);
    }

    System.out.println("Time for isAlphaNumericRegEx: " + (System.nanoTime() - startNanos) + " ns");

    startNanos = System.nanoTime();

    for (String testString: testStrings)
    {
        isAlphaNumericIsLetterOrDigit(testString);
    }

    System.out.println("Time for isAlphaNumericIsLetterOrDigit: " + (System.nanoTime() - startNanos) + " ns");      
}

private static boolean isAlphaNumericOriginal(String s)
{
    boolean valid = true;
    for (char c : s.toCharArray()) 
    {
        int type = Character.getType(c);
        if (type == 2 || type == 1 || type == 9) 
        {
            // the character is either a letter or a digit
        }
        else 
        {
            valid = false;
            break;
        }
    }

    return valid;
}

private static boolean isAlphaNumericFast(String s)
{
    boolean valid = true;

    char[] a = s.toCharArray();

    for (char c: a)
    {
        valid = ((c >= 'a') && (c <= 'z')) || 
                ((c >= 'A') && (c <= 'Z')) || 
                ((c >= '0') && (c <= '9'));

        if (!valid)
        {
            break;
        }
    }

    return valid;
}

private static boolean isAlphaNumericRegEx(String s)
{
    return Pattern.matches("[\\dA-Za-z]+", s);
}

private static boolean isAlphaNumericIsLetterOrDigit(String s)
{
    boolean valid = true;
    for (char c : s.toCharArray()) { 
        if(!Character.isLetterOrDigit(c))
        {
            valid = false;
            break;
        }
    }
    return valid;
}