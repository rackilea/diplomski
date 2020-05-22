// Each single thread brings resultItems from DynamoDB
StatelessSession session = factory.openStatelessSession();
Transaction tx = session.beginTransaction();
for(int i = 0; i < resultItems.size(); i++) {
    Customer cust = new Customer(resultItems.get(i));   
    Long id = session.save(cust); // get the generated id
    // TODO: Create a list of related customer users and assign the id to all of them and then save those customer user objects in the same transaction.  
    if(i % BATCH_SIZE == 0) {
        session.flush();
        session.clear();
    }
}
tx.commit();
session.close();