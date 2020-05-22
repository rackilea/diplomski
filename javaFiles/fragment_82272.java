public class BossQuest implements Serializable {
    private String name;
    private transient int status = 42;

    public BossQuest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private Object readResolve() {
        this.status = 42;
        return this;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        BossQuest in = new BossQuest("test");
        in.setStatus(987);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(in);
        oos.close();

        byte[] b = baos.toByteArray();

        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(b));
        BossQuest out = (BossQuest) ois.readObject();
        System.out.println(out.getName()); // prints test
        System.out.println(out.getStatus()); // prints 42
    }
}