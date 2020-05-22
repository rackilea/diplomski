public Object readObjectFromMemory(String filename) {
    FileInputStream fis;
    Object obj;
    try {
        fis = game.openFileInput(filename);
        ObjectInputStream is = new ObjectInputStream(fis);
        obj = is.readObject();
        is.close();
    } 
    catch (...) {
        return null;
    }

    return obj;
}