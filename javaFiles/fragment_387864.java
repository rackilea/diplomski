Public List<myPojoClass> getDataByCriterion( List<Criterion> restrictionList) {
Session s = HibernateUtil.currentSession();
Criteria c = s.createCriteria(myPojo.class);
for (Criterion crit : restrictionList){
    c.add(crit);
}

List<myPojoClass> response = c.list();