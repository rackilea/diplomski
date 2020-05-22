public class CompletelyStatic {

    @Inject
    private Config configProvider;

    // Keep a static private instance of your Static class
    private static CompletelyStatic cs = new CompletelyStatic();

    //If needed, make the constructor of your class private
    private CompletelyStatic(){
    }

    public final static String DEFAULT_PARAM = "abc";

    public static String doSomethingSpecial() {
        return "qqq" + cs.getConfigProvider().getSpecialParam(DEFAULT_PARAM);
    }

    public Config getConfigProvider(){
        return configProvider;
    }
}