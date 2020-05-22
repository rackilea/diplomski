public static void main(String[] args) {
    ExpressionTokenizer et = new ExpressionTokenizer("123 + 5 + 4");
    while(et.peekToken() != null) {
        System.out.println(et.nextToken());
    }
}
//tokens are 123, +, 5, +, 4