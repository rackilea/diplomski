public class PilotRepositoryImpl implements PilotRepositoryCustom{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Pilot findByNicknameFetchInactiveShips(String nickname) {
        Session session = entityManager.unwrap(Session.class);
        session.enableFilter("active").setParameter("active", false);
        Query query = entityManager.createQuery(
                "SELECT p FROM Pilot p " +
                "LEFT JOIN FETCH p.playerShips ps " +
                "LEFT JOIN FETCH ps.ship s " +
                "WHERE p.nickname = (:nickname)");
        query.setParameter("nickname", nickname);
        return (Pilot)query.getSingleResult();
    }
}