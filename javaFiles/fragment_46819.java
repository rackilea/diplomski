public void getFolderJson(String path, Callback<String, String> callback) {  
    RequestBuilder builder = new RequestBuilder(...);
    try {
      builder.sendRequest(null, new RequestCallback() {  
        @Override  
        public void onResponseReceived(Request request, Response response) {
          callback.onSuccess(response.getText());  
        }  
        @Override  
        public void onError(Request request, Throwable exception) {}
          callback.onFailure(exception.getMessage());  
        });
    } catch (RequestException e) {
        callback.onFailure(exception.getMessage());  
    }  
}