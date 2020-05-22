abstract class Packet<T extends Packet<T>> {
  /**
   *  Factory method.
   *  Override this method in sub-packets to return appropriate handlers
   */
  abstract PacketHandler<T> getHandler();
}