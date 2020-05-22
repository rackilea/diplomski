beginTransaction();
Foo foo = em.find(Foo.class, 1);
Bar newBar = new Bar();
//set up your Bar
foo.getBarCollection().add(newBar);
commitTransaction();