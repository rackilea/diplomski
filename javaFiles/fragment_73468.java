static <E extends NotesAttached> List<E> deserialise(String type)
        throws IOException, ClassNotFoundException {
    String fileName = "C:/temp/SalesModel." + type + ".list.ser";
    try (FileInputStream serFile = new FileInputStream(fileName),
         ObjectInputStream in = new ObjectInputStream(serFile)) {
        List<E> list = (List<E>) in.readObject();
        System.out.println(type + "s deserialised successfully, " + list.size() + " retrieved");
        return list;
    }
}