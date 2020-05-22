class Signal <T> { // notice the generic introduction here: <T>

    String ref;
    T payload; // now we can use T to represent any generic type

    public Signal(String ref, T payload) { // same here
        this.ref = ref;
        this.payload = payload;
    }
}