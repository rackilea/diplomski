try {
    FileOutputStream fos = new FileOutputStream(filename);
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    oos.writeObject(arraylist);
    oos.close();
} catch(Exception e) {
    e.printStackTrace();
}