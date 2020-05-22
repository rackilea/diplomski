public void exit() {
    //...
    DataOutputStream dout = new DataOutputStream(new FileOutputStream(STATE_FILE));
    dout.write(somefloat);
    dout.write(someInt);
    dout.write(someDouble);
}

public void startup() {
    DataInputStream dout = new DataInputStream(new FileInputStream(STATE_FILE));
    //exactly the same order, otherwise it's going to return weird data
    dout.read(somefloat);
    dout.read(someInt);
    dout.read(someDouble);
}