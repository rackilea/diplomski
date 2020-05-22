try(FileOutputStream f = new FileOutputStream("file.txt");
    ObjectOutput s = new ObjectOutputStream(f)) {
    s.writeObject(beginner);
    s.writeObject(intermediate);
    s.writeObject(expert);
}