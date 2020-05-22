catch(Exception e){
if(e instanceof TransactionRollbackException){
 //Retrigger Your Transaction
   }
// log your exception or throw it its upto ur implementation
}