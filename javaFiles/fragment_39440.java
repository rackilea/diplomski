session.beginTransaction();
String password=login_name.getLogin_password();
String username=login_name.getLogin_name();
Query query=session.createQuery("select login_id,login_name,login_password from Login where login_name= :username and login_password= :password ");
query.setParameter("username", username);
query.setParameter("password", password);
return query.list();