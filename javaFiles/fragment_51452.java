// On Sender side
 Object m = ... ;
 OutputStream out = ... ;

 WireToOutputStream wireToOutputStream = new 
 WireToOutputStream(WireType.TEXT, out);

 Wire wire = wireToOutputStream.getWire();
 wire.getValueOut().typeLiteral(m.getClass());
 Wires.writeMarshallable(m, wire);
 wireToOutputStream.flush();