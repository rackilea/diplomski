try {
    Future<Object> returnedObj = threadPool.submit(task);
    toReturn = returnedObj.get(timeout, timeunit);
    break;
} catch (Exception ex) {
   if(i == retries -1) {
       throw ex;
   }