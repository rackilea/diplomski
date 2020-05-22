public void someMethod(long parentEntityId, long childEntityId)
{
    EntityManager em = getSomeEntityManager();

    SomeEntity parentEntity = em.find(SomeEntity.class, parentEntityId);
    SomeEntity childEntity = em.find(SomeEntity.class, childEntityId);

    parentEntity.addUsing(childEntity);
}