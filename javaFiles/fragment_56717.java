@Entity
public class Node {

    @Id
    public int id;

    public String nodeName;

    @ManyToMany
    @JoinTable(name="relationships")
    public List<Node> parents;

    @ManyToMany(mappedBy="parents")
    public List<Node> children;

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(new Node());
        transaction.commit();
        entityManager.close();
    }

}