class CallsCppGetData {
    int num;
    byte[] bytes;

    native void cppGetData(); // sets this.num and this.bytes.
}