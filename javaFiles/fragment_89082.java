HttpRequestResponse hrr = new HttpRequestResponse(){

    @Override
    public void onSuccess(HttpResponse response) {
       hideProgressDialog();
       handleResponse(response);
    }

    @Override
    public void onException(Exception exception) {
       hideProgressDialog();
       showErrorDialog(exception.getMessage());
    } 
 }

 HttpRequestResponseHandler hrrh = new HttpRequestResponseHandler(ActionItem.LOGIN_REQUEST,hrr);
 hrrh.execute();
 showProgressDialog();