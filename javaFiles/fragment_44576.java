public void foo(String subject) {
    System.out.println("subject"); // -> private static final String SUBJECT2 = "subject";
}

public void bar() {
    System.out.println("subject"); // -> private static final String SUBJECT = "subject";
}