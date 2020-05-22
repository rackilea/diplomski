public void addMessages(int ID, List<Message> messages) {

    ObjectOutput output = null;
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ByteArrayInputStream bais = null;
    output = new ObjectOutputStream(CryptoHandler.encryptedStream(baos));
    output.writeObject(messages);
    output.close(); // it shouldn't remain open after writing the object
    bais = new ByteArrayInputStream(baos.toByteArray());
    getMessages(ID, bais);
}