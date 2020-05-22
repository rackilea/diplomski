public class MapSerializationTest {
    private static class Foo implements Serializable {
    }

    public static void main(String[] args) throws Exception {
        Foo foo = new Foo();

        Map<String, Foo> map1 = new HashMap<String, Foo>();
        map1.put("foo", foo);
        Map<String, Foo> map2 = new HashMap<String, Foo>();
        map2.put("foo", foo);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(map1);
        oos.writeObject(map2);
        oos.close();

        byte[] bytes = baos.toByteArray();

        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bais);
        map1 = (Map<String, Foo>) ois.readObject();
        map2 = (Map<String, Foo>) ois.readObject();
        System.out.println(map1.get("foo") == map2.get("foo")); // prints true
    }
}