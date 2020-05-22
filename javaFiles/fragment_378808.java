public static <T> boolean isValid(T data,
        Function<? super T, Integer> timeGetter,
        Function<? super T, String> usernameGetter,
        Function<? super T, Integer> businessValueGetter) {
    return (timeGetter.apply(data) > 100 || usernameGetter.apply(data) != null && businessValuesGetter.apply(data) > 0);
    // or something more complex
}

public static boolean isValid(Data data) {
    return isValid(data, Data::getTime, Data::getUserName, Data::getBusinessValue);
}

public static boolean isValid(SapData data) {
    return isValid(data, SapData::getTime, SapData::getUserName, SapData::getBusinessValue);
}