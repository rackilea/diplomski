@PersistenceContext
private EntityManager em;

//@Transactional - Not Java EE, anyway I keep it as notice that the method is invoked in a transaction.
public Role activateUser(long id) {
    Role role = em.find(Role.class, id);        
    role.setAccountStatus(AccountStattus.ACTIVATED.toString());
    //Thats all.
}