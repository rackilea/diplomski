// write
oos.writeInt(bundle.size());
for (String key : bundle.keySet()) {
    Object value = bundle.get(key);
    oos.writeObject(key);
    oos.writeObject(value);
}

// read
int size = ios.readInt();
Map<String, Object> map = new ArrayMap<String, Object>();
for (int i = 0; i < size; i++) {
    String key = (String) ios.readObject();
    Object value = ios.readObject();
    map.put(key, value);
}