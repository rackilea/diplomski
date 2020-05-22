public static Test1 createObject() {
    // create a single instance the first time around
    if (tstObj == null) {
        tstObj = new Test1();
    }
    // otherwise return the instance which already exists
    return tstObj;
}