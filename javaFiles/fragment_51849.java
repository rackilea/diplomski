// Serialize the ArrayList mapData
try (OutputStream file = new FileOutputStream("res/Saved Maps/"+fileName+".map");
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);) {
    output.writeObject(mapData);
} catch (IOException ex) {
    System.out.println("Error ocurred: " + ex.getMessage());
}

// Deserialize the 'fileName'.map file
try (InputStream file = new FileInputStream("'fileName'.map");
        InputStream buffer = new BufferedInputStream(file);
        ObjectInput input = new ObjectInputStream(buffer);) {
    // Deserialize the ArrayList (serialized on this file)
    ArrayList<byte[]> recoveredMapData = (ArrayList<byte[]>) input.readObject();
    // Display its data
    for (byte[] cell_byte : recoveredMapData) {
        System.out.println("=> " + cell_byte);
    }
} catch (ClassNotFoundException ex) {
    System.out.println("Error ocurred: " + ex.getMessage());
} catch (IOException ex) {
    System.out.println("Error ocurred: " + ex.getMessage());
}