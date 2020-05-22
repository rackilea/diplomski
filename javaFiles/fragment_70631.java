public void saveData() {
    EntityA a = new EntityA(...);
    EntityB b = new EntityB(...);
    a.setEntityB(b);
    b.setEntityA(a);

    entityManager.persist(a);
    ...
}