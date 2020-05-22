pointcut afterCreateSupermarket():
    call(ISupermarket ca1.business.SupermarketFactory.createSupermarket(..));

after() returning(Object result): afterCreateSupermarket() {
    supermarket = (ISupermarket) result;
}