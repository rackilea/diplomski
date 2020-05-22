@Transactional
@Repository
public class EmailDAO{
    @Autowired
    private SessionFactory sessionFactory;

    public Email create(Email email) {
        sessionFactory.getCurrentSession().save(email);
        return email;
    }

    public Email getEmail(String inputEmail) {
        Email email = null;
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Email e WHERE e.emailaddress = :email");
        query.setString("email", inputEmail);
        List emails = query.list();
        if(emails != null && emails.size() > 0) {
            email = (Email)emails.get(0);
        } else {
            email = new Email();
            email.setEmailAddress(inputEmail);
        }
        return email;
    }
}