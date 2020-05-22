static void serialize(Object o, OutputStream outputStream){
    try(ByteArrayOutputStream bos = new ByteArrayOutputStream(); 
        ObjectOutput objectOutput = new ObjectOutputStream(bos)){
        objectOutput.writeObject(o);
        objectOutput.flush();
        byte[] bytes = bos.toByteArray();
        outputStream.write(bytes);
    } catch (IOException e) {
        e.printStackTrace();
    } 
}