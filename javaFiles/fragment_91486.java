interface BooleanUnaryOperator {
    boolean apply(int x);
}

public static void setAll(boolean[] array, BooleanUnaryOperator generator) {
    for (int i = 0; i < array.length; i++)
        array[i] = generator.apply(i);
}