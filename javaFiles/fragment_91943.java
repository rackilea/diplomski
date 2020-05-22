Long activity = ...;
int year = ...;

Query q = entityManager.createNativeQuery(
    "select count(*) as Count, MONTH(Stored) as Month " +
    "from adbtbl_stat " +
    "where Activity = :activity and YEAR(Stored) = :year"
);
q.setParameter("activity", activity);
q.setParameter("year", year);
List<Object[]> result = (List<Object[]>) q.getResultList();