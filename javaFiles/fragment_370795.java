EntityManager em = getEntityManager();
CriteriaBuilder builder = em.getCriteriaBuilder();
List<Teacher> result = Collections.EMPTY_LIST;

CriteriaQuery<Teacher> criteria = builder.createQuery(Teacher.class);
criteria.createAlias("courses", "c")
       .add(Restrictions.eq("c", searchCriteria.getCourse());