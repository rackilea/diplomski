public static <T> Vector<T> concatenateVector(Vector<T> baseVector, Vector<T> additionVector) {

    additionVector.removeAll(baseVector)
    baseVector.addAll(additionVector);
    return baseVector;
}