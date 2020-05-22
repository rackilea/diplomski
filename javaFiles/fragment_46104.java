public class ClientModel implements Serializable{
    private static final long serialVersionUID = -4507489610617393544L;

    String name = "";
    int data = 1;

    void print() {
        System.out.println(data +": " + name);
    }
}