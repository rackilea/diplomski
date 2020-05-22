public class Main {

    public static void main(String[] args) {
         FileIOPas fileiopas = new FileIOPas();
         Paslijst paslijst = new Paslijst();
         paslijst.setPaslijst(fileiopas.openen("test.txt"));
    }
}

public class FileIOPas {

    public ArrayList<Pas> openen(String filenaam) {

        try (FileInputStream fileInputStream = new FileInputStream(filenaam);
                ObjectInputStream objectInputStream = new ObjectInputStream(
                        fileInputStream);) {
            return (ArrayList<Pas>) objectInputStream.readObject();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return null;
    }

}

public class Paslijst implements Serializable {

    private ArrayList<Pas> paslijst;

    public ArrayList<Pas> getPaslijst() {
        return paslijst;
    }

    public void setPaslijst(ArrayList<Pas> paslijst) {
        this.paslijst = paslijst;
    }

}