@Entity
@Table(name ="keypairs")
public class KeyPairDomain {

    private Long id;
    private String username;
    private byte[] byteObject;
    private KeyPair keypair;

    public KeyPairDomain(KeyPair kpair, String username) {
        super();
        this.setUsername(username);
        this.keypair = kpair;
    }

    @Transient
    public KeyPair getKeypair() {
        return keypair;
    }


    public void setKeypair(KeyPair complexObject) {
        this.setKeypair(complexObject);
        ByteArrayOutputStream baos;
        ObjectOutputStream out;
        baos = new ByteArrayOutputStream();
        try {
            out = new ObjectOutputStream(baos);
            out.writeObject(complexObject);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.byteObject = baos.toByteArray();
    }

    @Column(columnDefinition = "bytea") 
    public byte[] getByteObject() {
    return byteObject;
    }

    public void setByteObject(byte[] byteObject) {
        ByteArrayInputStream bais;
        ObjectInputStream in;
        try {
            bais = new ByteArrayInputStream(byteObject);
            in = new ObjectInputStream(bais);
            setKeypair((KeyPair) in.readObject());
            in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        this.byteObject = byteObject;
    }

    public String getUsername() {
        return username;
    }

    @Column(name = "username")
    public void setUsername(String username) {
        this.username = username;
    }

    @Id
    @GeneratedValue 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}