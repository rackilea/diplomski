@Override
public void run() {
   Channel.writeAndFlush(message.content()).addListener(new ChannelFutureListener() {
     @Override
     public void operationComplete(ChannelFuture future) throws Exception {
        channelPool.returnObject(future.channel());
     }
   });
}