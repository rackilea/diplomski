public MyPOJO findByQuery(int hour) 
{ 
    return this.getHibernateTemplate().executeFind(new HibernateCallback<List<MyPOJO>>() {
        List<MyPOJO> doInHibernate(org.hibernate.Session session) {
            Query query = session.createSQLQuery(    
                "SELECT * FROM MyPOJO WHERE someDate >= DATE_SUB(now(), INTERVAL ? HOUR)")    
                    .addEntity(MyPOJO.class);    
            return query.setInteger(0, hours).list();    
        }
    });
}