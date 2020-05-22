submissionTree = new Tree<SubmissionMenuData, SubmissionMenuData>(submissionTreeStore, new ValueProvider<SubmissionMenuData, SubmissionMenuData>() {
    @Override
    public SubmissionMenuData getValue(SubmissionMenuData object) {
        return object; // just return the object itself - how to display it will be handled later
    }

    @Override
    public void setValue(SubmissionMenuData object, SubmissionMenuData value) {
        // ... not relevant here
    }

    @Override
    public String getPath() {
        return "value";
    }
});