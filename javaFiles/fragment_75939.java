public static String[] subExprs(String expr) {
    /* Actual logic to split the expression */
    int fromIndex = 0;
    int subExprStart = 0;
    ArrayList<String> subExprs = new ArrayList<String>();
    again:
    while ((subExprStart = expr.indexOf("(", fromIndex)) != -1) {
        fromIndex = subExprStart;
        int substringEnd=0;
        while((substringEnd = expr.indexOf(")", fromIndex)) != -1){
            subExprs.add(expr.substring(subExprStart, substringEnd+1));
            fromIndex = substringEnd + 1;
            continue again; 
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