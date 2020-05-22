private void writeObject(ObjectOutputStream oos)
throws IOException {
    // default serialization 
    oos.defaultWriteObject();
    // write the object
    List loc = new ArrayList();
    loc.add(location.x);
    loc.add(location.y);
    loc.add(location.z);
    loc.add(location.uid);
    oos.writeObject(loc);
}

private void readObject(ObjectInputStream ois)
throws ClassNotFoundException, IOException {
    // default deserialization
    ois.defaultReadObject();
    List loc = (List)ois.readObject(); // Replace with real deserialization
    location = new Location(loc.get(0), loc.get(1), loc.get(2), loc.get(3));
    // ... more code

}