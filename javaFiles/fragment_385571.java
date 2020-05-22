public Table1 getByTable2AndColumn1(Table2 table2, 
                                     String column1, String column2) {

Criteria criteria = sessionFactory.getCurrentSession()
                                  .createCriteria(Table1.class);

if (table2 == null){
    return null;
}

if (column1 == null){
    criteria.add(Restrictions.or(Restrictions.isNull("column1"), 
                                               Restrictions.eq("column1", "")));
}else{
    criteria.add(Restrictions.eq("column1", column1));
}

if (column2==null){
    criteria.add(Restrictions.isNull("column2"));
}else{
    criteria.add(Restrictions.eq("column2", column2));
}

Criteria c = criteria.createCriteria("table2");
c.add(Restrictions.eq("id", table2.getId()));
c.setMaxResults(1);

return (Table1) c.uniqueResult();
}