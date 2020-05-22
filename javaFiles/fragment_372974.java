public List findEmployees(Date endDate) {
  return entityManager.createQuery(
    "SELECT e from Employee e WHERE e.startDate BETWEEN ?1 AND ?2")
    .setParameter(1,new Date(), TemporalType.DATE)
    .setParameter(2,endDate, TemporalType.DATE).getResultList();
}