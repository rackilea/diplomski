class MyApp {
    public static final main(){
        new MyApp().run();
    }

    private void run(){
        MyRepositoryProcessor proc = new MyRepositoryProcessor();

        try {
            // Some loop here maybe...
            proc.deleteFromRepo();
        } catch (MyDatabaseCommunicationException ex) {
            System.exit(-1);
        }
    }
}

class MyRepositoryProcessor {
    public void deleteFromRepo() throws MyDatabaseCommunicationException {
        try {
            //start transaction
            repository.startTransaction();

            //carry out deletion logic
            repository.deletedata()

            //commit all 3 operations
            repository.commitTransaction();

        }catch (Exception e) {
            try {
                repository.rollback();
            } catch (Exception ex){
                // Database connection failed completely, could not even do a rollback.
            }
            throw new MyDatabaseCommunicationException("Deletion failed");
        }
    }
}