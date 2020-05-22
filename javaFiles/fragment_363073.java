public T findOrCreate(final T t) throws InvalidRecordException {
   // 1) look for the record
   T found = findUnique(t);
   if (found != null)
     return found;
   // 2) if not found, start a new, independent transaction
   TransactionTemplate tt = new TransactionTemplate((PlatformTransactionManager)
                                            transactionManager);
   tt.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
   try {
     found = (T)tt.execute(new TransactionCallback<T>() {
        try {
            // 3) store the record in this new transaction
            return store(t);
        } catch (ConstraintViolationException e) {
            // another thread or process created this already, possibly
            // between 1) and 2)
            status.setRollbackOnly();
            return null;
        }
     });
     // 4) if we failed to create the record in the second transaction, found will
     // still be null; however, this would happy only if another process
     // created the record. let's see what they made for us!
     if (found == null)
        found = findUnique(t);
   } catch (...) {
     // handle exceptions
   }
   return found;
}