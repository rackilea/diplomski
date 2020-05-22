@Override
public List<Contact> query(LoadGroup group) {
    TypedQuery<Contact> query = em.createQuery("SELECT c FROM Contact c", Contact.class);
    if(group!=null) { query.setHint(QueryHints.LOAD_GROUP, group); }
    return query.getResultList();
}