public static String[] subExprs(String expr) {

    /* Actual logic to split the expression */
    int fromIndex = 0;
    int subExprStartParanthesis = 0;
    int subExprStartSquareBrackets = 0;
    ArrayList<String> subExprs = new ArrayList<String>();
    again: while ((subExprStartParanthesis = expr.indexOf("(", fromIndex)) > -2
            && (subExprStartSquareBrackets = expr.indexOf("[", fromIndex)) > -2) {

        /* Check the type of current bracket */
        boolean isParanthesis = false;
        if (subExprStartParanthesis == -1
                && subExprStartSquareBrackets == -1)
            break;
        else if (subExprStartParanthesis == -1)
            isParanthesis = false;
        else if (subExprStartSquareBrackets == -1)
            isParanthesis = true;
        else if (subExprStartParanthesis < subExprStartSquareBrackets)
            isParanthesis = true;

        /* Extract the sub expression */
        fromIndex = isParanthesis ? subExprStartParanthesis
                : subExprStartSquareBrackets;
        int subExprEndParanthesis = 0;
        int subExprEndSquareBrackets = 0;
        if (isParanthesis) {
            while ((subExprEndParanthesis = expr.indexOf(")", fromIndex)) != -1) {
                subExprs.add(expr.substring(subExprStartParanthesis,
                        subExprEndParanthesis + 1));
                fromIndex = subExprEndParanthesis + 1;
                continue again;
            }
        } else {
            while ((subExprEndSquareBrackets = expr.indexOf("]", fromIndex)) != -1) {
                subExprs.add(expr.substring(subExprStartSquareBrackets,
                        subExprEndSquareBrackets + 1));
                fromIndex = subExprEndSquareBrackets + 1;
                continue again;
            }
        }
    }

    /* Logic only for printing */
    System.out.println("Original expression : " + expr);
    System.out.println();
    System.out.print("Sub expressions : [ ");
    for (String string : subExprs) {
        System.out.print(string + ", ");
    }
    System.out.print("]");
    String[] subExprsArray = {};
    return subExprs.toArray(subExprsArray);
}