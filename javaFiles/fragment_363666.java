public enum RomanNumerals
{
    I (1),
    V (5),
    X (10),
    L (50),
    C (100),
    D (500),
    M (1000);

    private final Integer value;

    RomanNumerals(Integer value) 
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }

    public static void main(String... args)
    {
        System.out.println("The roman numeral 'V' value is: " + V.value);
    }
}