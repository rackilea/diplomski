@Transactional
public List<Child> findAllChild(int id) {
    // TODO Auto-generated method stub
    HibernateUtil.initManager();
    HibernateUtil.getEntityManager().clear();
    Query query = HibernateUtil.getEntityManager().createQuery("SELECT child FROM Child child JOIN FETCH child.family  WHERE child.family.id = :userId ");
    query.setParameter("userId",id);
    List<Child> result = query.getResultList();
    HibernateUtil.shutdown();
    return result;
}