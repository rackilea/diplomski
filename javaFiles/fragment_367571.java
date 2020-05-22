interface PacketHandler<P extends Packet<P>> {
  boolean handle(P p);
}

class ThisPacketHandlerImpl implements PacketHandler<ThisPacket> {
  @Override
  public boolean handle(ThisPacket p) {
    return false;
  }

}

class ThatPacketHandlerImpl implements PacketHandler<ThatPacket> {
  @Override
  public boolean handle(ThatPacket p) {
    return false;
  }
}