ByteBuffer eventTypeBuffer = ByteBuffer.allocate(1);
eventTypeBuffer.put(0x1c);
eventTypeBuffer.flip();
ByteString eventType = ByteString.copyFrom(eventTypeBuffer);
System.out.println(eventType.size() + " " + eventTypeBuffer.array().length);

Header.Builder mh = Header.newBuilder();
mh.setEventType(eventType);