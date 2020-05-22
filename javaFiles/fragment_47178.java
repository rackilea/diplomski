@Stateless
public class userDAO {

    @PersistenceContext(unitName = "SensorCloudPU")
    protected EntityManager em;

    public void deleteUserByUserNameAndOrganization(String userName, Organization org) {
        Query q = this.em.createNamedQuery(User.Q_GET_BY_USERNAME_AND_ORGANIZATION);
        q.setParameter("organization", org);
        q.setParameter("user_name", userName);
        User u = this.executeQueryForSingleResult(q);
        if (u != null) {
            this.em.remove(u);
        }
    }
}