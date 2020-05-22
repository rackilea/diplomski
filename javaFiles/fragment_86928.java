public Channel makeObject() throws Exception {
   System.out.println("Create new channel!!!");
   //bootstrap.validate(); // this is implicitely called in connect()
   ChannelFuture future = bootstrap.connect(host, port).awaitUninterruptibly();
   if (future.isSuccess()) {
     return future.channel();
   } else {
     // do what you need to do when the connection is not done
   }
}