package helper;

public class AppHelper {
    private static String module = "default";
    private static String layout = "main";
    private static String page = "index";

    public static String getModule() {
        return module;
    }
    public static void setModule(String module) {
        AppHelper.module = module;
    }
    public static String getLayout() {
        return layout;
    }
    public static void setLayout(String layout) {
        AppHelper.layout = layout;
    }
    public static String getPage() {
        return page;
    }
    public static void setPage(String page) {
        AppHelper.page = page;
    }
}