public class Serializables {
    public static Object FromString(String s) {
        Object o = null;
        try {
            byte[] data = Base64.getDecoder().decode(s);
            ObjectInputStream ois = new ObjectInputStream(
                    new ByteArrayInputStream(data));
            o = ois.readObject();
            ois.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return o;
    }

    // Modified from source: http://stackoverflow.com/questions/134492/how-to-serialize-an-object-into-a-string
    public static String ToString( Serializable o ) {
        ByteArrayOutputStream baos = null;
        try {
            baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(o);
            oos.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        return Base64.getEncoder().encodeToString(baos.toByteArray());
    }
}