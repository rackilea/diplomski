public static void expMember(){
    Session session=HibernateUtil.getSessionFactory().openSession(); 

    java.util.Date utilDate=new java.util.Date();
    java.sql.Date sqldate=new java.sql.Date(utilDate.getTime());

    Format formatter = new SimpleDateFormat("yyyy-MM-dd");
    String a= formatter.format(sqldate);  

    Query query = session.createSQLQuery (" update tbl_member set exp_status = 'true' where renewDate="+"'" + a + "';";

    int result = query.executeUpdate();

    System.out.println(result);
    }