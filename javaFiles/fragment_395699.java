// add a new private field to the modified class for tracking version:
private int myNewVersionFlag = 123;

// then in your readObject implementation:
private void readObject(java.io.ObjectInputStream stream)
     throws IOException, ClassNotFoundException {

    stream.defaultReadObject();

    if( this.myNewVersionFlag == 0 ) {
        // if we get here the object being deserialized must
        // be an old version, so now set sensible defaults 
        // for the new params or whatever...
    }

}