if (packet_length != -1 && packet_length > 0) {
    packet.position(packet_length);  // filled till that pos
    packet.flip();                   // No more writes, make it ready for reading

   // Do read from packet buffer
   // then, packet.clear() or packet.compact() to read again.
}