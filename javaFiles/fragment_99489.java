if( postInsertEvent.getEntity() instanceof ClassThatNeedsToBeHandled ) {
  ClassThatNeedsToBeHandled insertedEntity = (ClassThatNeedsToBeHandled )postInsertEvent.getEntity(); 
  Session subSession = postInsertEvent.getSession().sessionWithOptions()
    .connection() //use the same connection as the parent session                  
    .noInterceptor() //we don't need additional interceptors
    .flushMode( FlushMode.AUTO ) //flush on close
    .autoClose( true) //close after the transaction is completed
    .autoJoinTransactions( true ) //use the same transaction as the parent session
    .openSession();

  subSession.saveOrUpdate( new SomeRelatedEntity( insertedEntity ) );
}