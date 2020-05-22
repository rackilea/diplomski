public void updatesAllFieldsOfDog() {
    //creates object with random values
    Dog original = dao.createDog(Dog.random());
    //create new object with random fields and set the ID to the original
    //which effectively means - original object with all fields updated
    Dog updated = Dog.random().setId(original.getId());
    dao.updateDog(updated);
    Dog fromDb = dao.getDog(original.getId());
    //Method from Unitils that compares all the fields
    assertReflectionEquals(updated, fromDb);
}