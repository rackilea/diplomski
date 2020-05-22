// On Receiver side
 InputStream in = ... ;

 InputStreamToWire inputStreamToWire = new InputStreamToWire(WireType.TEXT, in);

 Wire wire2 = inputStreamToWire.readOne();
 Class type = wire2.getValueIn().typeLiteral();
 Object m = ObjectUtils.newInstance(type);
 Wires.readMarshallable(m, wire2, true);