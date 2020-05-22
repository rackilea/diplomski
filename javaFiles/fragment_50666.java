public String backup() {
    try {
        ByteArrayOutputStream b= new ByteArrayOutputStream();
        ObjectOutputStream o= new ObjectOutputStream(b);
        o.writeObject(this.allShapes);
        o.close();
        return Base64.getEncoder().encodeToString(b.toByteArray());
    } catch (IOException e) {
        return "";
    }
}

public void restore(String state) {
    try {
        byte[] data = Base64.getDecoder().decode(state);
        ObjectInputStream o = new ObjectInputStream(new ByteArrayInputStream(data));
        this.allShapes = (CompoundShape) o.readObject();
        o.close();
    } catch (ClassNotFoundException e) {
        System.out.print("ClassNotFoundException occurred.");
    } catch (IOException e) {
        System.out.print("IOException occurred.");
    }
}