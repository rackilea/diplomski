public static void main(String[] args) {
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("a");
    stringList.add("b");
    stringList.add("c");

    for(String s : stringList) {
        lambdaExpressionEquivalent(s);
    }
}

private static void lambdaExpressionEquivalent(String str) {
    if (str.equals("b")) {
        return;
    }

    System.out.println(str);
}