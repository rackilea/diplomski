RequestBuilder r = new RequestBuilder(RequestBuilder.GET, jsonUrl);
r.sendRequest(null, new RequestCallback() {
    public void onError(Request request, Throwable exception) {
        // error
    }

    public void onResponseReceived(Request request, Response response) {
        if (response.getStatusCode() == 200) {
            //do something
        } else if (response.getStatusCode() == 302) {
            //do something else
        }
    }
});