// Serialize data object to a file
ObjectOutputStream out = new ObjectOutputStream(
        new FileOutputStream(filePath) );
out.writeObject(doc);
out.close();


FileInputStream fis = new FileInputStream(
        filePath
);
ObjectInputStream reader = new ObjectInputStream(fis);
doc = (StyledDocument) reader.readObject();