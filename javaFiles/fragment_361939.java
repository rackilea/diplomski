private void writeObject(ObjectOutputStream oos) {
    oos.defaultWriteObject();
    // custom serialization
    oos.writeInt(notSerializableObj.getId());
}

private void readObject(ObjectInputStream ois) {
    ois.defaultReadObject();
    // custom de-serialization
    notSerializableObj = new NotSerializableObj(ois.readInt());
}