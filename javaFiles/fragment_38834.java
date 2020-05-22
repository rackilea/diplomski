Stream.Listener responseListener = new Stream.Listener.Adapter() {
    @Override
    public void onHeaders(Stream stream, HeadersFrame frame) {
        MetaData metaData = frame.getMetaData();
        if (metaData.isResponse()) {
            MetaData.Response response = (MetaData.Response)metaData;
            int status = response.getStatus();
            ...
        }
    }

    @Override
    public void onData(Stream stream, DataFrame frame, Callback callback) {
        ...
    }
};