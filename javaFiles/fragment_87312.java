interface ResponseHandler {
   void onComplete(Response response);
   void onError(Throwable error);
}

interface SomeService {
   void set(String attribute, Object value, ResponsHandler responseHandler);
   void get(String attribute, ResponseHandler responseHandler);
}