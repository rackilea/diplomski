public List getGirls(Boy boy, Date startDating) {
  Criteria c = sessionFactory.getCurrentSession().createCriteria(BoyGirl.class);
  c.add(Restrictions.eq("boy.id", boy.getId()));
  c.add(Restrictions.lt("startDating", startDating));

  List<BoyGirl> boyGirls = (List<BoyGirl>) c.list();
  // at this point you have lazily fetch girl attributes
  // if you need the girl  attributes to be initialized uncomment line below
  // for (BoyGirl boyGirl : boyGirls) Hibernate.initialize(boyGirl.getGirl());

  return boyGirls;
}