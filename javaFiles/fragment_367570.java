class ThisPacket extends Packet<ThisPacket> {
  @Override
  PacketHandler<ThisPacket> getHandler() {
    return new ThisPacketHandlerImpl();
  }
}

class ThatPacket extends Packet<ThatPacket> {
  @Override
  PacketHandler<ThatPacket> getHandler() {
    return new ThatPacketHandlerImpl();
  }
}