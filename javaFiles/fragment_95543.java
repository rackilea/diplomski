protected <T> T callWithTrace(Supplier<T> fn) throws Exception {
  //some code before the call
  try {
     T output=fn.get();
     //code after normal exec
     return output;
  }
  catch(Exception e) {
     //code in case of error (increase counter??)
     throw e;
  }
}

void someOtherMethod() {
   Object ret = callWithTrace({ () -> callToYourDangerousMethod()});
   Object ret = callWithTrace({ () -> callToAnotherDangerousMethod()});
}