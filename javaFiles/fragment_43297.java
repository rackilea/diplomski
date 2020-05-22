// Serialization
ByteArrayOutputStream bo = new ByteArrayOutputStream();
ObjectOutputStream so = new ObjectOutputStream(bo);
so.writeObject(myObject);
so.flush();
byte[] serializedObject = bo.toByteArray();

// Deserialization
MyOwnObject deserializedObject = null;
try {
    ByteArrayInputStream bis = new ByteArrayInputStream(serializedObject);
    ObjectInputStream ois = new ObjectInputStream(bis);
    deserializedObject = (MyOwnObject)ois.readObject();
    ois.close();
} catch (Exception e){
    e.printStackTrace();
}