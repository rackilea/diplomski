@Embeddable
public class Ent2Id implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 3000940427471306899L;

    Integer eid1 = 0;
    Integer eid2 = 1;

    public Ent2Id() {

    }

    public Ent2Id(Integer a, Integer b) {
        eid1 = a;
        eid2 = b;
    }
}