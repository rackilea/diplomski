public class Main {
    public static void main(String... args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(new AuthAccount("u", "p"));
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
        Object aa = ois.readObject();
    }
}
 class AuthAccount implements Serializable{
    private static final long serialVersionUID = 1;
    private final String username;
    private final String password;

    AuthAccount(String user, String pass){
        username = user;
        password = pass;
    }
    String username(){
        return username;
    }
    String password(){
        return password;
    }
}