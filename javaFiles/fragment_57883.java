try {
    String conversion = infix.convert(str);
    System.out.println(postfix.eval(conversion));
} catch (InfixToPostfix.SyntaxErrorException e) {
    ...
} catch (PostfixEvaluator.SyntaxErrorException e) {
    ...
}