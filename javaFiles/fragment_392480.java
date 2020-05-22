public OptionalInt reduce(IntBinaryOperator op) {
    boolean foundAny = false;
    int result = 0;

    for (int element : [this stream]) {
        if (!foundAny) {
            foundAny = true;
            result = element;
        }
        else {
            result = op.applyAsInt(result, element);
        }
    }

    return foundAny ? OptionalInt.of(result)
                    : OptionalInt.empty();
}