public static void main(String args[]) {
    Q1 q1 = new Q1();
    Q2 q2 = new Q2();
    try {
        // this prints "abc" and no exception is thrown
        System.out.println(q2.method(q1));

        // this throws a new QE2(), which prints
        // this prints "qe2 - 1" followed by "qe2 - 2"
        System.out.println(q2.method(q2));
    } catch(QE1 e) {
        System.out.println("exception 1");
    } finally {
        // your code ends up here, which prints "finally"
        System.out.println("finally");
    }
}