public <T extends String> int someFunction1(T someParam) {
    return someFunction2(someParam);
}

public int someFunction2(String someParam) {
    return 1;
}