public static Condition template(...) {
    Condition result = DSL.trueCondition();

    if (...)
        result = result.and(...);

    return result;
}