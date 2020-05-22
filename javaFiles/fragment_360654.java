public void searilizePlant(ArrayList<Plant> _plants) {
    try {
        FileOutputStream fileOut = new FileOutputStream(fileName);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(_plants);
        out.close();
        fileOut.close();
    } catch (IOException ex) {
    }
}

public List<Plant> deserializePlant() {
    List<Plants> plants = null;
    try {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
        plants = in.readObject(); 
        in.close();
    }
    catch(Exception e) {}
    return plants;
}