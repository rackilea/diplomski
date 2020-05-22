private void sendObject(ObjectOutputStream output) {

    try {
        output.writeObject(object);
        output.flush();
        output.reset();
    }catch (Exception e) {
        e.printStackTrace();
    }
    return;     
}