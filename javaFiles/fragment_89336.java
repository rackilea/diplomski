private static volatile int connectedClients = 0;
public static void callBack () throws Exception{
    //....
           ch.pipeline().addLast(new RequestDataEncoder(), new ResponseDataDecoder(),
                                 new ClientHandler(i -> {connectedClients = i;});
    //....
}

public static void main(String[] args) throws Exception {

  callBack();
  while (true) {
    System.out.println("The number if the connected clients is not two");
    int ret = connectedClients;
    if (ret == 2){
        break;
    }
  }
  System.out.println("The number if the connected clients is two");
}

public class ClientHandler extends ChannelInboundHandlerAdapter {
  public final IntConsumer update;
  public ClientHandler(IntConsumer update) {
      this.update = update;
  }

  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
      RequestData msg = new RequestData();
      msg.setIntValue(123);
      msg.setStringValue("all work and no play makes jack a dull boy");
      ctx.writeAndFlush(msg);
  }

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
      System.out.println(msg);
      update.accept(Integer.parseInt(msg));
  }
}