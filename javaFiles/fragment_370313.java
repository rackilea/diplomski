public class CustomTestRunner extends AndroidJUnitRunner {
    @Override
    public Application newApplication(ClassLoader cl, String className, Context context)
    throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return super.newApplication(cl, FakeJourneyStoreApplication.class.getName(), context);
    }
}