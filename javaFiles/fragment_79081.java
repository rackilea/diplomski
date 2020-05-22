@Override
public <T extends ODataCallback> T getCallback(Class<T> callbackInterface) {
  if(callbackInterface.isAssignableFrom(ODataErrorCallback.class)) {
   return (T) new MySampleErrorCallback();
}
return super.getCallback(callbackInterface);
}

private class MySampleErrorCallback implements ODataErrorCallback {
@Override
public ODataResponse handleError(ODataErrorContext context) throws  ODataApplicationException {
  LOG.error("Error...");
  return EntityProvider.writeErrorDocument(context);
}