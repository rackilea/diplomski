EntityManager em = emf.createEntityManager();
Query query = em.createQuery("Select u.id_page,u.title from Cms u");
List<Object[]> results = query.getResultList();
for(Object[] elements: results){
Long id = Long.valueOf(String.valueOf(elements[0]));
String title  = String.valueOf(elements[1]);
}