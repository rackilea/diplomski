@ChannelHandler.Sharable
public class MyFilterHandler extends IpFilteringHandlerImpl {
  private final Set<InetSocketAddress> deniedRemoteAddress;

  public MyFilterHandler(Set<InetSocketAddress> deniedRemoteAddress) {
    this.deniedRemoteAddress = deniedRemoteAddress;
  }

  @Override
  protected boolean accept(ChannelHandlerContext ctx, ChannelEvent e, InetSocketAddress inetSocketAddress) throws Exception {
    return !deniedRemoteAddress.contains(inetSocketAddress);
  }
}