public static Drawing deepClone(Drawing drawing) {
    try {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(drawing.shapes); //Serializes the drawing.shapes

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais); 
        return new Drawing((LinkedList<Shape>)ois.readObject()); //Deserializing and reading 
    } catch (IOException e) {
        return null;
    } catch (ClassNotFoundException e) {
        return null;
    }
}