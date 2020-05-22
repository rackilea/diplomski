mDataCastConsumerImpl = new DataCastConsumerImpl(){
   public void onMessageSendFailed(Status status) {
       // do as you want
   }
   ....
}

...
mDataCastManager.addDataCastConsumer(mDataCastConsumerImpl);
...