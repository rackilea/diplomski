JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT){
    private final int location = 100;
    {
        setDividerLocation( location );
    }
    @Override
    public int getDividerLocation() {
        return location ;
    }
    @Override
    public int getLastDividerLocation() {
        return location ;
    }
};