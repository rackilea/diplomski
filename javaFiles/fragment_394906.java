if (!identifiersMap.isEmpty()) {
    context.setRollbackOnly();

    BusinessException e = new BusinessException();
    e.setValues(identifiersMap.values()); // here is where the problem is
    throw e;
}