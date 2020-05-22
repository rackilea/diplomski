@Root
public class MyArrayList<E> {   
    @ElementList(inline=true)
    ArrayList<E> list = new ArrayList<E>();

    public boolean add(E entry) {
        return list.add(entry);
    }

    public void ToXml() throws Exception {
        Serializer serializer = new Persister();
        File file = new File("somewhere in my file system");
        serializer.write(this, file);
    }
}