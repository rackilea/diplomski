try {
    entityManager.persist(object);

} catch (InvalidStateException e) {

    log.info("Caught Hibernate exception: #0", e.getClass().getName());

    InvalidValue[] invalidValues = e.getInvalidValues();

    for(InvalidValue invalidValue : invalidValues) {
        log.info("Invalid Property #0 has value: #1", invalidValue.getPropertyName(), invalidValue.getPropertyName());
    }
}