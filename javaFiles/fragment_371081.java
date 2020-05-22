@Transactional
public void deleteByName(String name) {
    String hql = "DELETE MP3  where name = :name";
    query = session.createQuery(hql);
    query.setParameter("name",name);
    query.executeUpdate();
}