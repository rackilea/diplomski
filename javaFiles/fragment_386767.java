RequestBuilder rb = new RequestBuilder(RequestBuilder.GET, GWT.getModuleBaseURL() + "path/to/servlet");
rb.setCallback(new RequestCallback() {

    public void onError(Request request, Throwable exception) {
        // do something
    }

    public void onResponseReceived(Request request, Response response) {
        if (200 == response.getStatusCode()) {
            UserOverlay userOverlay = asUserOverlay(response.getText());
            // continue handling
        }
    }
});
rb.send();