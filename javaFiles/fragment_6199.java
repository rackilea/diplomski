//...
HttpResponse response = httpclient.execute(httppost);
if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
  //edit: there is already function for this
  return EntityUtils.toString(response.getEntity(), "UTF-8");
} else {
  //Houston we have a problem
  //we should do something with bad http status
  return null;
}