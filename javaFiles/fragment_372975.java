//Get next month
DateTime dt = new DateTime();
entityManager.createQuery(
"SELECT e from Employee e WHERE e.startDate BETWEEN ?1 AND ?2")
.setParameter(1,new Date(), TemporalType.DATE)
.setParameter(2,dt.plusMonths(1).toDate(), TemporalType.DATE).getResultList();