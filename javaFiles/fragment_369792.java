String sql = "SELECT id AS row_id, friendlyName AS name FROM SomeTable";
Session session = JPA.em().unwrap(Session.class);
SQLQuery q = session.createSQLQuery(sql);

q.setResultTransformer( new FooResultTransformer() );
List<Foo> fooList = q.list();