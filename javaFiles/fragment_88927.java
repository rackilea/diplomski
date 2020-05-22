public static <A, B> B[] transform(Class<B> theReturnedValueType, Function<A, B> functionToApply, A... theValues) {

    B[] transformedValues = (B[]) Array.newInstance(theReturnedValueType, theValues.length);

    for (int i = 0; i < theValues.length; i++) {
        transformedValues[i] = functionToApply.apply(theValues[i]);
    }

    return transformedValues;
}