IOFileFilter counter = new IOFileFilter() {

    @Override
    public boolean accept(File arg0, String arg1) {
        countCall();
        return true;
    }

    @Override
    public boolean accept(File arg0) {
        countCall();
        return true;
    }
};