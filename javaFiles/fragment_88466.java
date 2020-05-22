class MyDecoder extends ByteToMessageDecoder {

    MyDecoder() {
        setSingleDecode(true);
    }

    // your decode impl as before
}