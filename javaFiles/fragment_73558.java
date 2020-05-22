public class MyDummyClass implements java.io.Serialiazable {
    // mark it transient so defaultReadObject()/defaultWriteObject() ignore it
    private transient com.google.android.gms.maps.model.LatLng mLocation;

    // ...

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeDouble(mLocation.latitude);
        out.writeDouble(mLocation.longitude);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        mLocation = new LatLng(in.readDouble(), in.readDouble());
    }
}