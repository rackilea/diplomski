StringTokenizer st = new StringTokenizer(strAll, "+-*/", true);
if (st.countTokens() == 3) {
    int operand1 = Integer.parseInt(st.nextToken().trim());
    String operator = st.nextToken();
    int operand2 = Integer.parseInt(st.nextToken().trim());

    switch (operator.charAt(0)) {
        case '+':
            PlusCalc P = new PlusCalc(operand1, operand2);
            listCalc[indexCalc] = P;
            indexCalc++;

            break;
        case '-':
            MinusCalc M = new MinusCalc(operand1, operand2);
            listCalc[indexCalc] = M;
            indexCalc++;

            break;

        default:
            System.out.println("Error!");

    }
}