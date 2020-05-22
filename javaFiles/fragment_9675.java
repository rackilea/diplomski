ArrayList<Data> list;
try {
    FileInputStream fis = new FileInputStream(filename);
    ObjectInputStream ois = new ObjectInputStream(fis);
    list = (ArrayList<Data>) ois.readObject();
    ois.close();
} catch(Exception e) {
    e.printStackTrace();
}