/**
 * In case that there is kinda bug in JAVA serializing HASHMAP, backstacks hashmap is writing to cache as object.
 */
private void serializeBackStack() {
    try {
        FileOutputStream fos =
                new FileOutputStream(getCacheDir() + "backstack.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(backStacks);
        oos.close();
        fos.close();
    } catch (IOException ioe) {
        ioe.printStackTrace();
    }
}


/**
 * Hashmap with backstacks is getting from object saved in cahse.
 *
 * @return HashMap
 */
private HashMap<TabType, Stack<String>> deserializeBackStack() {
    HashMap<TabType, Stack<String>> map = new HashMap<>();
    try {
        FileInputStream fis = new FileInputStream(getCacheDir() + "backstack.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        map = (HashMap<TabType, Stack<String>>) ois.readObject();
        ois.close();
        fis.close();
    } catch (IOException ioe) {
        ioe.printStackTrace();
        return new HashMap<>();
    } catch (ClassNotFoundException c) {
        c.printStackTrace();
        return new HashMap<>();
    }

    if (map != null)
        return map;
    else
        return new HashMap<>();
}