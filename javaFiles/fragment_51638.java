Criteria c = session.createCriteria(SomeDomain.class, "x");
if (a != null) {
    c.add(Restrictions.eq("x.linkToSomeA", a));
}
if (b != null) {
    c.add(Restrictions.eq("x.linkToSomeB", b));
}
// ...