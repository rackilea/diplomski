while (true) {
   ...
   Future<Void> timeoutTask = activityTimeOut.schedule(new CloseConnection(/*init with streams*/), Globals.INACTIVITY_TIME_OUT, TimeUnit.MILLISECONDS);
   try {
      AMessageStrategy incomingCommand = (AMessageStrategy) myInputStream.readObject();
   } finally {
      timeoutTask.cancel(false);
   }
   ...
}