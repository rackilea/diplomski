public void destroyObject(final Channel channel) throws Exception {
   channel.close().addListener(new ChannelFutureListener() {
      @Override
      public void operationComplete(ChannelFuture close) {
        if (close.isSuccess()) {
           System.out.println(channel + " close successfully");
        }
      }
   });
}