//first start a tx
TransactionManager tm = ...
tm.begin();

Waiter waiter = new Waiter();

//the code that calls the first EIS; defined by you
SubTxCode code1 = ...

//the associated thread
SubTxThread thread1 = new SubTxThread ( waiter , code1 );

//the code that calls the second EIS; defined by you
SubTxCode code2 = ...

//the associated thread
SubTxThread thread2 = new SubTxThread ( waiter , code2 );

//start each thread
thread1.start();

thread2.start();

//wait for completion of all calls
waiter.waitForAll();

//check result
if ( waiter.getAbortCount() == 0 ) {
    //no failures -> commit tx
    tm.commit();
} else {
    tm.rollback();
}