public static int methodContainingMethod(
    int a, int b, int c, BiFunction<Integer, Integer, Integer> theFunction) {

    int value = theFunction.apply(a, b);
    for(int i=0; i<asDeepAsYouWannaGo; i++)
        value=theFunction.apply(value, c);
    return value;
}