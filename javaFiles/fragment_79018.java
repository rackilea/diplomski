public class MenuScreen extends ScreenAdapter {
    private final AnalyticsUtils analyticsUtils;

    @Inject 
    public MenuScreen(GameName game, AnalyticsUtils analyticsUtils) {
        this.analyticsUtils = analyticsUtils;
        // Some initialization.
        useAnalytics();
    }

    private void useAnalytics() {
        analyticsUtils.someMethod();
    }
}