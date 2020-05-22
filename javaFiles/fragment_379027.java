MyObject o = new MyObject();
Kryo kryo = new Kryo();
kryo.register(MyObject.class);

ObjectBuffer ob = new ObjectBuffer(kryo);
byte[] myByteArray = ob.writeObject(o);