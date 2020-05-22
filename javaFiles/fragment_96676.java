private Optional<SomeObject> getObjFromService(Service someService) {
    try {
        return Optional.of(someService.getSomeObject());
    } catch (ServiceException e) {
        LOG.error("Something nasty happened", e);
    }
    return Optional.empty();
}