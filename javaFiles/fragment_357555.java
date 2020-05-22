@Stateless
@LocalBean
public class DAO {

    @PersistenceContext
    EntityManager em;

    public void createConnection(String nickName, String roomName) {
        Connexion c = new Connexion();
        c.setNickName(nickName);
        c.setRoomName(roomName);
        c.setConnectionDate(new Timestamp((new java.util.Date()).getTime()));
        em.persist(c);
    }