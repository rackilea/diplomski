@Root
public class MyArrayList<E> extends ArrayList<E> {      
    @ElementList(inline=true)
    MyArrayList<E> list = this;

    public void ToXml() throws Exception {
        Serializer serializer = new Persister();
        File file = new File("somewhere in my file system");
        serializer.write(this, file);
    }
}