public class MyObjectOutputStream extends ObjectOutputStream {

    public void writeObjectReplace(Object o) {
        if( o instanceof MyUnserializableClass ) {
            o = new ReplacementClass(o);
        }
        super.writeObjectReplace(o);
    }

}

public class ReplacementClass implements Serializable {

    Object o;  

    public ReplacementClass(Object o) {
        this.o = o;
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        ...writeObjectToStreamWithMethodsIn stream....
    }

    public Object readReplace(ObjectInputStream stream) {
        ...createOriginalObjectWithDataFromStream...
    }

}