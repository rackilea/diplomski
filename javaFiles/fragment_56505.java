private void sendObject(ObjectOutputStream output) {

    try {
        output.writeObject(object);
        output.flush();
    }catch (Exception e) {
        e.printStackTrace();
    }
    return;     
}