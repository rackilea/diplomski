protected void onPostExecute(String result) {
try {
  Class<?> cl = ServiceToActivity.getSingletonClass();
  Method met = cl.getMethod("retrieveResult", String); //String because result is of type String: you can use result.getClass() instead
  met.invoke(cl.cast(ServiceToActivity.getSingleton()), result); // compare it to this ServiceToActivity.getSingleton().retrieveResult(result);
} catch (JSONException e) {
  e.printStackTrace();
}
}