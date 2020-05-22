public static enum PlayerDefaults
{

    Name("$Name$"),
    Money(2000),
    Warnings(0);

    public static void reset() {
        Name.value = "$Name";
        Money.value = 2000;
        Warnings.value = 0;
    }