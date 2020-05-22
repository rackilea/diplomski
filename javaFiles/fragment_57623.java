@Override
protected void onEndRequest() {
    super.onEndRequest();
    ((WebResponse) response).setHeader("X-custom", "..." );
    // ...
}