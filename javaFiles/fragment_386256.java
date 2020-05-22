public static Map<String, Integer> deSerializeHashMap() throws ClassNotFoundException, IOException {
    FileInputStream fis = new FileInputStream("/opt/hashmap.ser");
    ObjectInputStream ois = new ObjectInputStream(fis);
    Map<String, Integer> map = (Map<String, Integer>) ois.readObject();
    ois.close();
    System.out.printf("De Serialized HashMap data  saved in hashmap.ser");
    return map;
}

public static void serializeHashMap(Map<String, Integer> hmap) throws IOException {
    FileOutputStream fos = new FileOutputStream("/opt/hashmap.ser");
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    oos.writeObject(hmap);
    oos.close();
    fos.close();
    System.out.printf("Serialized HashMap data is saved in hashmap.ser");
}