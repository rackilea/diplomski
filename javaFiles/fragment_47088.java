public void createChild(String firstName, String lastName, int age, int parentId) {
    Parent parent = entityManager.getReference(Parent.class, parentId);
    Child child = new Child();
    child.setFirstName(firstName);
    child.setLastName(lastName);
    child.setAge(age);
    child.setParent(parent);
    entityManager.persist(child);
}