class AnotherUtils {
    public static Data getData() {...}

    public static DataProvider getProvider() {
        return AnotherUtils::getData;
    }
}