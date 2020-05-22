@Resource
private SessionContext sessionContext;

void execute(){

UserTransaction userTxn = sessionContext.getUserTransaction();

try{

 userTxn.begin();
 /**
  *  do-something
  */
 userTxn.commit();

  } catch(Throwable e){
   userTxn.rollback(); //-- Include this in try-catch 
  }
}