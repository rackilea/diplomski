class Bar() {

    @Inject DBAcessor mDBAcessor;

    Bar (DBAcessor dbAcessor) {
        this.mDBAcessor = dbAcessor;
    }

    public Object getContent() {
        mDBAcessor.fetchData();
    }
}