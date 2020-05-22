@PersistenceContext
private EntityManager em;

@Override
public void save(Document document) {
    if (document.getId() == null) {this.em.persist(document);}
    else {this.em.merge(document);}
}