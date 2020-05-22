// inject a reference to the servlet container JTA tx
@Resource UserTransaction jtaTx;

// servlet container-managed EM
@PersistenceContext private EntityManager em; 

public void save(Document document) {
    try {
        jtaTx.begin();
        try {
            if (document.getId() == null) {this.em.persist(document);}
            else {this.em.merge(document);}
            jtaTx.commit();
        } catch (Exception e) {
             jtaTx.rollback();
             // do some error reporting / throw exception ...
        }
    } catch (Exception e) {
        // system error - handle exceptions from UserTransaction methods
        // ...
    }
}