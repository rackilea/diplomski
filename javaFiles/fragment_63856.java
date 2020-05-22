public boolean doSomething(String param1, String param2) {
    if (!Objects.equals(param1, "String1") &&
        !Objects.equals(param1, "String2") &&
        !Objects.equals(param1, "String3"))
    {
        throw IllegalArgumentException("param1 must be String1, 2, or 3");
    }

    ...
}