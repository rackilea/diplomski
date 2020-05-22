ByteBuffer buf = ByteBuffer.wrap(header);
buf.setOrder(ByteOrder.BIG_ENDIAN);
buf.put((byte)((Version << 6)|(Padding << 5)|(Extension << 6)|CC));
buf.put((byte)((Marker << 7)|PayloadType));
buf.put((short)SequenceNumber);
buf.put(TimeStamp);
buf.put(Ssrc);