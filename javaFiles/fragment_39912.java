void unsafeMod(Vector data) {
    for (Object o : data) {
        if (o != null) {
            data.remove(o); // may cause CME
        }
    }
}