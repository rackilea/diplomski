public class SocialNetwork  implements Serializable{
    // lots of fields

    private static SocialNetwork myself = new SocialNetwork();

    private SocialNetwork(){ // private constructor
        //lots of inilization
    }

    public static SocialNetwork getInstance() { 
        return myself; 
    }

    public void writethisObject() throws IOException{...}

    public void readfromObject(File f) throws IOException, ClassNotFoundException{
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(f));
        myself = (SocialNetwork) objectInputStream.readObject();
    }

}