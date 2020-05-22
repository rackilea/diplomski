{
        InputStream inputStream = rcvStream;

        byte[]  inData      = new byte[1024];
        int     bytesRead   = inputStream.read();
        byte[]  actualData  = new byte[bytesRead];
        System.arraycopy(inData, 0, actualData, 0, bytesRead);

        jni.setByteArray(inData, bytesRead);
}