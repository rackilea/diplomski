try {
  response = connection.call(request, endpoint);
} catch (SOAPException soapEx) {
  if(soapEx.getCause().getCause() instanceof SocketTimeoutException) {
    throw new TimeoutExpirationException(); //custom exception
  } else {
    throw soapEx;
  }
}