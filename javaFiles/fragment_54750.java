@Rule
public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class) {

    @Override
    protected void beforeActivityLaunched() {
        super.beforeActivityLaunched();
    }

};