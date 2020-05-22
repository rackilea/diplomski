try {
    validatorService.validate( obj );
} catch (ValidationException e) {
    entityManager.detach(obj);
    //Or with Hibernate API
    //session.evict(obj); 
    throw e;
}