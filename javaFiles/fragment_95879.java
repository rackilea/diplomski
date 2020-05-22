<E extends BaseEntity> E find(E clientEntity) {
    E entity = entityManager.find(clientEntity.getClass(), clientEntity.getId());
    if (entity.getVersion() != clientEntity.getVersion()) {
        throw new ObjectOptimisticLockingFailureException(...);
    }
    return entity;
}