ctx.writeAndFlush(response).addListener(new ChannelFutureListener() {
  @Override
  public void operationComplete(ChannelFuture future) {
    if (future.isDone()) {
      Message newMsg = createMessage();
      ctx.writeAndFlush(newMsg);
    } else { // an error occurs, do perhaps something else
    }
  }
});