public class Year4DWraper implements Serializable{

    private Year4D year4d;

    public Year4DWraper(Year4D year4d) {
        this.year4d = year4d;
    }
    public Year4D getYear4D(){
        return yeard4D;
    }

    private void writeObject(ObjectOutputStream os)
            throws IOException {
       os.writeInt(year4D.getYear());

    }

    private void readObject(ObjectInputStream is)
            throws IOException, ClassNotFoundException {
       int year = is.readInt();
       year4D = new Yeard4D(year);
    }

}