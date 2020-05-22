class EnumUtils {

    public static <T extends Enum<T>> String[] getStringValues(Class<T> enumClass) {
        return getStringValuesWithStringExtractor(enumClass, Enum::name);
    }

    public static <T extends Enum<T>> String[] getStringValuesWithStringExtractor(
            Class<T> enumClass,
            Function<? super T, String> extractor
    ) {
        return of(enumClass.getEnumConstants()).map(extractor).toArray(String[]::new);
    }

}