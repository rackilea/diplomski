public class Serialize {

    public static void main(String[] args) throws Exception {
        SignedTimestamp o = new SignedTimestamp(100L, new byte[]{ (byte) 128 }, "Hello, world!");
        System.out.println(Serializables.ToString(o));
    }
}