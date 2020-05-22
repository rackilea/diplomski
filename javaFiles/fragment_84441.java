/**
 * This method will write your stock information into a file
 * @param path Is the target path in your file system
 * @param list Is the list you want to save
 * @throws IOException 
 * @throws FileNotFoundException 
 */
public void writeStockInfo(String path, LinkedList<StockItem> list) throws FileNotFoundException, IOException {
    //1. Point to your file using File
    File file =  new File(path);
    //2. Then use OOS but to serialize into a file you should use FileOutputStream inside the invocation
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
    //3. Just write the object to a file using the method "writeObject"
    objectOutputStream.writeObject(list);
    //4. Close the streams
    objectOutputStream.close();
}

/**
 * This method will read the information of the stock in a file
 * @param path Is the file from which you will read the info
 * @return
 * @throws IOException 
 * @throws FileNotFoundException 
 * @throws ClassNotFoundException 
 */
public LinkedList<StockItem> readStockInfo(String path) throws FileNotFoundException, IOException, ClassNotFoundException {
    LinkedList<StockItem> infoList = new LinkedList<StockItem>();
    //1. Point to your file (the one you want to read)
    File fileToRead = new File(path);
    //2. Use OIS to read the information from a file using FileInputStream
    ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileToRead));
    //3. Just read the object and cast to make sure you obtain the right object
    infoList = (LinkedList<StockItem>) objectInputStream.readObject();
    //4. Close the stream
    objectInputStream.close();
    return infoList;
}