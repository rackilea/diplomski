public MyPOJO findByQuery(int hour) 
{ 
    Session s = null;
    try {
        s = this.getSession();
        Query query = s.createSQLQuery( 
        "SELECT * FROM MyPOJO WHERE someDate >= DATE_SUB(now(), INTERVAL ? HOUR)") 
        .addEntity(MyPOJO.class); 

        List<MyPOJO> results = query.setInteger(0, hours).list(); 

        return results; 
    } finally {
        if (s != null) this.releaseSession(s);
    }        
}