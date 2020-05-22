public class DataSourceReplacementPlugin extends PlayPlugin {
    public void onApplicationStart() {
        DB.datasource = new DataSourceWrapper(DB.datasource);
    }

    public void onApplicationStop() {
        if (DB.datasource instanceof DataSourceWrapper) {
            DB.datasource = ((DataSourceWrapper) DB.datasource).getOriginal();
        }
    }
}