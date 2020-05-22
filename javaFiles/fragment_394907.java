if (!identifiersMap.isEmpty()) {
    context.setRollbackOnly();

    BusinessException e = new BusinessException();
    e.setValues(new ArrayList(apIdentifiersMap.values())); // problem fixed
    throw e;
}