class DataNode extends SingleNode {
    private  String mStringData;
    private  Integer mIntegerData;
    public DataNode( AbstractGraph graph, final String id) {
        super(graph, id);
    }
    public void setStringData(String mStringData) {
        this.mStringData = mStringData;
    }
    public void setIntegerData(Integer mIntegerData) {
        this.mIntegerData = mIntegerData;
    }
    public String getStringData() {
        return mStringData;
    }
    public Integer getIntegerData() {
        return mIntegerData;
    }
}