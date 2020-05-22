// Write
List<User> userList = new ArrayList<User>();
try (FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos)) {
    oos.writeObject(userList);
} catch (IOException e1) {
    e1.printStackTrace();
}

// read
try (FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis)) {
    userList = (List<User>) ois.readObject();
} catch (FileNotFoundException  | IOException | ClassNotFoundException e1) {
    e1.printStackTrace();
}