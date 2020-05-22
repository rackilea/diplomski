import com.google.gwt.http.client.*;
...

String url = "http://www.myserver.com/getData?type=3";
RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode(url));

try {
  Request request = builder.sendRequest(null, new RequestCallback() {
    public void onError(Request request, Throwable exception) {
       // Couldn't connect to server (could be timeout, SOP violation, etc.)
    }

    public void onResponseReceived(Request request, Response response) {
      if (200 == response.getStatusCode()) {
          // Process the response in response.getText()
      } else {
        // Handle the error.  Can get the status text from response.getStatusText()
      }
    }
  });
} catch (RequestException e) {
  // Couldn't connect to server
}