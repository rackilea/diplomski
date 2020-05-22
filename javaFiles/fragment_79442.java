public static void httpGetFile(final String url, final AsyncCallback<String> callback) {
    final RequestBuilder rb = new RequestBuilder(RequestBuilder.GET, url);
    rb.setCallback(new RequestCallback() {
        public void onResponseReceived(Request request, Response response) {
            try {
                final int responseCode = response.getStatusCode() / 100;
                if (url.startsWith("file:/") || (responseCode == 2)) {
                    callback.onSuccess(response.getText());
                } else {
                    callback.onFailure(new IllegalStateException("HttpError#" + response.getStatusCode() + " - " + response.getStatusText()));
                }
            } catch (Throwable e) {
                callback.onFailure(e);
            }
        }

        public void onError(Request request, Throwable exception) {
            callback.onFailure(exception);
        }
    });
    try {
        rb.send();
    } catch (RequestException e) {
        callback.onFailure(e);
    }
}