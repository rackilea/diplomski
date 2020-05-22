Handler handler = new Handler(handlerThread.getLooper()){
   @Override
   public void handleMessage(Message msg) {
      // Do action based on this message
   }
}