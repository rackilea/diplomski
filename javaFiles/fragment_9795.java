Sesion sess = getSession();
Query mySelect = sess.createSQLQuery("SELECT * from foo");
List<Entity> results = mySelect.list();

Query myUpdate = sess.createSQLQuery("DELETE * from foo where bar = \"boz\"");
int updateCount = myUpdate.executeUpdate();