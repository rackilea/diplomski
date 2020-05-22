public class AutoSaveService implements ScheduledService<Void> {

    @Override
    protected Task<Void> createTask() {
        // retrieve data from UI. This should be done here,
        // as you should access the data on the FX Application Thread
        final MyDataType data = getDataFromUI(); 
        return new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                vb.save(data);
                return null ;
            }
        };
    }
}