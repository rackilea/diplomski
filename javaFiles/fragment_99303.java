public class Something implements Serializable {
    private static final long serialVersionUID = 1L;
    public int value = 2;
    private File file = new File("something.serial");
    private Marshaller marshaller = new Marshaller();
}