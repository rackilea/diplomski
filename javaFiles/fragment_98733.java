Service<DataHelper> service = new Service<DataHelper>() {
    @Override
    protected Task<DataHelper> createTask() {
        return new Task<DataHelper>() {
            @Override
            protected DataHelper call() throws Exception {
                i.incrementAndGet(); // Don't worry about i here 
                return new DataHelper("Word " + i, "Meaning " + i, "Sentence " + i);
            }
        };
    }
};