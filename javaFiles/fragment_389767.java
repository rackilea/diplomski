public static int processStringA(DummyString string)
{
    if (string == null) return -2;
    return processStringB(string);
}

public static int processStringB(DummyString string)
{
    if (string == null) return -3;
    return processStringC(string);
}

public static int processStringC(DummyString string)
{
    if (string == null) return -4;
    return string.value;
}