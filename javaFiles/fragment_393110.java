txTemplate.execute(new TransactionCallback<Void>(){
    public Void doInTransaction(TransactionStatus txStatus){
    try{
        for (Person person : personList1) {
            System.out.println("x");
            registerPerson(person);
        }
    } catch(RuntimeException e){
        txStatus.setRollbackOnly();
        throw e;
    }
    return null;
    }
});