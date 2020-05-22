private <T> T[] arrayCopy(T[] original) {

    //get the class type of the original array we passed in and determine the type, store in arrayType
    Class<?> arrayType = original.getClass().getComponentType();

    //declare array, cast to (T[]) that was determined using reflection, use java.lang.reflect to create a new instance of an Array(of arrayType variable, and the same length as the original
    T[] copy = (T[])java.lang.reflect.Array.newInstance(arrayType, original.length);

    //Use System and arraycopy to copy the array
    System.arraycopy(original, 0, copy, 0, original.length);
    return copy;
}