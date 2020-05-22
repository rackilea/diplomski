@Test
  public void parentRepositoryMustPersistParentAndChildren() {
    Parent parent = new Parent("Anakin", "Skywalker");
    parent.getChildren().add(new Child("Luke"));
    parent.getChildren().add(new Child("Leia"));

    Parent saved = parentRepository.save(parent);

    Assert.assertNull("Parent does not have and id assigned after persist it", saved.getParentId());
    saved.getChildren().forEach((child) ->{
      Assert.assertNull("Parent does not have and id assigned after persist it", child.getChildId());
    });

  }