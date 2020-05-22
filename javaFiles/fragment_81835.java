public static SessionResult<?> testYay() {
    return SessionResult.NoSession$.MODULE$;
}

public static SessionResult<?> testNay1() {
    return null;
}

public static SessionResult<?> testNay2() {
    return SessionResult.Expired$.MODULE$;
}

public static <T> SessionResult<T> testNay3() {
    return null;
}

public static void blah() {
    //prints true
    System.out.println(testYay() instanceof SessionResult.NoSession$);
    //prints false
    System.out.println(testNay1() instanceof SessionResult.NoSession$);
    //prints false
    System.out.println(testNay2() instanceof SessionResult.NoSession$);
    //prints false (and compiles)
    System.out.println((SessionResult<?>) testNay3() instanceof SessionResult.NoSession$);
}