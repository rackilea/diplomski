Transaction tx = session.beginTransaction();

PersonEntity entityFromTheClient = getPersonEntityFromClient();

//this is the data that i pull from the db for the merge
PersonEntity entityFromDb = getPersonEntityFromDb(entityFromTheClient.getID()); 

entityFromDb.setA(entityFromTheClient.getA());
entityFromDb.setB(entityFromTheClient.getB());

tx.commit();