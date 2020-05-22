public class CompletelyStatic {

    public final static String DEFAULT_PARAM = "abc";

    //Keep a static reference to the ConfigProvider object.
    private static Config configProvider;

    public static String doSomethingSpecial(Config configProvider) {
        CompletelyStatic.configProvider = configProvider;
        return "qqq" + otherMethod(configProvider);
    }

    // Here, you will not need to parameterize your other methods.
    private static String otherMmethod() {
        return "more logic " + configProvider.getSpecialParam(DEFAULT_PARAM);
    }
}