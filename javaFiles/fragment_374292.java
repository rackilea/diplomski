public class SpecificDAO extends SomeBaseWritableDAO<SpecificEntity> {

    public SpecificEntity findBySomeCode(String inviteCode) {
        final String queryString = "select model from SomeEntity model " +
                "where model.code= :inviteCode";

        Query query = getEntityManager().createQuery(queryString);
        query.setParameter("inviteCode", inviteCode);

        try {
            return (SomeEntity) (query.getSingleResult());
        }
        catch( NoResultException nre ) {
            return null;
        }
    }
}