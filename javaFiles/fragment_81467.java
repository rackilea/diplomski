AjaxLoaderOptions options = AjaxLoaderOptions.newInstance();
options.setPackages("corechart");
AjaxLoader.loadApi("visualization", "1", new Runnable() {
    @Override
    public void run() {
        jsniCall();
}