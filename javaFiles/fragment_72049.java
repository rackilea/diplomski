protected void submitEmailFormRequestBuilder(TextBox name, TextBox email, TextBox message) {

  // create the request content in a way that the php script can read it:
  // for every textbox the php textbox-name = user-value
  StringBuilder requestData = new StringBuilder();
  requestData.append( "name=" + name.getValue() );
  requestData.append( "&email=" + email.getValue() );
  requestData.append( "&message=" + message.getValue() );

  // create the REST request callback
  RequestCallback callback = new RequestCallback() {

    @Override
    public void onResponseReceived(Request request, Response response) {
      String errorMessage = response.getText();

      // TODO: handle potential error-message

    }

    @Override
    public void onError(Request request, Throwable exception) {
      // TODO: handle timeouts and other sending failures like cross-domain posting

    }
  };

  // create the REST request as POST request
  RequestBuilder build = new RequestBuilder( RequestBuilder.POST, "/contextRoot/email.php" );
  try {
    build.sendRequest( requestData.toString(), callback );
  }
  catch (RequestException e) {
    // handle exception
  }
}