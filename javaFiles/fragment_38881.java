public class Foo implements java.io.Serializable{   

    //...

    public void write() throws IOException{
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Test.bin"));
        os.writeObject(this);
        os.close();
    }   

}