@SuppressWarnings("unchecked")
List<User> listUser = (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class)
   .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

for (User user : listUser) {
   Hibernate.initialize(user.getRole());
}