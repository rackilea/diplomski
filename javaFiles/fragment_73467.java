static <E extends NotesAttached> List<E> deserialise(String type)
        throws IOException, ClassNotFoundException {
    String fileName = "C:/temp/SalesModel." + type + ".list.ser";
    FileInputStream serFile = new FileInputStream(fileName);
    ObjectInputStream in = new ObjectInputStream(serFile);
    try {
        List<E> list = (List<E>) in.readObject();
        System.out.println(type + "s deserialised successfully, " + list.size() + " retrieved");
        return list;
    } finally {
        // See notes
        in.close();
        serFile.close();
    }
}