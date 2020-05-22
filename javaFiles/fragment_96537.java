public static void main(String[] args)
{
    long hex = 0x2222222222222222L;

    System.out.printf("0x%x", replaceDigit(hex, 10, 1));
}

public static long replaceDigit(long originalValue, int digitPosition, int replacementDigit)
{
    // Clear the 4 bits (i.e. 1 digit) at the position requested
    originalValue &= ~(0x0FL << digitPosition * 4);

    // Now put the replacement value at the position requested
    originalValue |= (long) replacementDigit << digitPosition * 4;

    return originalValue;
}