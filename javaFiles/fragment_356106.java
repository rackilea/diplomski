MyEntity instance = myEntityService.read(instance.getId());
    if (instance == null) {
      instance = new MyEntity();
    }
    fillEntityFromRequest(instance, request);
    myEntityService.save(instance); // calls saveOrUpdate() method