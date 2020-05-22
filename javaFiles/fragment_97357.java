import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;

RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.POST, jsonServiceUrl);
requestBuilder.setHeader("Content-Type", "application/json; charset=utf-8");

RequestCallback jsonCallback = new RequestCallback () {
  @Override
  public final void onResponseReceived(Request request, Response response) {
     hideWaitingMessage();
     handleJsonResponse(request, response);
  }
  @Override
  void onError(Request request, Throwable exception) {
     hideWaitingMessage();
     handleError(response, exception);
  }
};

String requestData = null;
displayWaitingMessage();
Request request = requestBuilder.sendRequest(requestData, jsonCallback);