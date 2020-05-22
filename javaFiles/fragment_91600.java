public static void main(String[] args) throws IOException {
    boolean a = true; // char: 84 or 116 for T and t
    boolean b = false; // char: 70 or 102 for F and f
    int userChar1;
    int userOperator;
    int userChar2;

    System.out.println("Please enter the term, e.g. T&F:");

    userChar1 = System.in.read();
    userOperator = System.in.read();
    userChar2 = System.in.read();

    a = userChar1 == 'T' || userChar1 == 't';
    b = userChar2 == 'T' || userChar1 == 't';

    switch (userOperator) {
    case '&':
        System.out.println(a & b);break;
    case '|':
        System.out.println(a | b);break;
    case '^':
        System.out.println(a ^ b);break;
    default:
        System.out.println("unknow operator");
    }
}