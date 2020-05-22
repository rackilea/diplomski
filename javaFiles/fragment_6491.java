Criteria criteria = session.createCriteria(A.class)
 .createAlias("b", "b_alias")
 .createAlias("c", "c_alias")
 .add(Restrictions.disjunction()
  .add(Restrictions.eq("b_alias.foo", "Something"))
  .add(Restrictions.eq("c_alias.bar", "0"))
 );