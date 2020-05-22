int ID = 1;
CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
Root<User> root = criteriaQuery.from(User.class);
criteriaQuery.select(root.get("name");
criteriaQuery.where(criteriaBuilder.equal(root.get("ID"), ID));

Query<String> query = session.createQuery(criteriaQuery);

List<String>results = query.getResultList();
for(String name : results){
    System.out.println("Name: " + name);
}