public static void serialize(Object obj, File f) throws IOException {
    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f))) {
       out.writeObject(obj);
    }
}

public static Object deserialize(File f)
        throws IOException, ClassNotFoundException {
    try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(f))) {
        return is.readObject();
    }
}

static class Thing implements Serializable {
    int a,b,c;
}
public static void main(String[] args) throws IOException, ClassNotFoundException {

    File f = new File("object.dat");
    Thing orig = new Thing();
    serialize(orig, f);
    Thing back = (Thing) deserialize(f);
}