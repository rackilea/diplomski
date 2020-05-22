class GarageManager {

    public static Garage GetGarage(String garagePath)
            throws FileNotFoundException, IOException, ClassNotFoundException {
        Garage x = null;
        File garageFile = new File(garagePath);
        if (!garageFile.exists() || garageFile.length() == 0) {
            ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(garageFile)));
            x = (Garage) ois.readObject();
            ois.close();
        } else {
            x = new Garage();
        }
        return x;
    }
}