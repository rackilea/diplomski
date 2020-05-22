public class WorkManagerInit extends ContentProvider {

    @Override
    public boolean onCreate() {
        if(getContext() != null) {
            Configuration config = new Configuration.Builder().build();
            WorkManager.initialize(getContext().getApplicationContext(), config);
        }
        return true;
    }
    ...
}