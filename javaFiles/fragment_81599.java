public static void receive(){
    try (
        ByteArrayInputStream byteIn = new ByteArrayInputStream();
        ObjectInputStream objectIn = new ObjectInputStream(new BufferedInputStream(byteIn));
    ) {
        //do something
    }
}