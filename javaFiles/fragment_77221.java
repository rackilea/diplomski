String QueryString = 'SELECT * FROM CUSTOMERS WHERE lastname = ?';
Query query = entityManager.createNativeQuery(QueryString); 
Session session = entityManager.unwrap(JpaEntityManager.class).getActiveSession();  
DatabaseQuery databaseQuery = query.unwrap(org.eclipse.persistence.jpa.JpaQuery.class).getDatabaseQuery();
DatabaseRecord recordWithValues= new DatabaseRecord();

query.setParameter(1, "toto"); 
recordWithValues.add(new DatabaseField(Integer.toString(1)), "toto");

databaseQuery.prepareCall(session, recordWithValues); 
String sqlStringWithArgs = databaseQuery.getTranslatedSQLString(session, recordWithValues);

System.out.print(sqlStringWithArgs);

====SELECT * FROM CUSTOMERS WHERE lastname = 'toto'====