Key key = datastore.newKeyFactory()
            .ancestors(PathElement.of("kind_of_parent", "id_of_parent"))
            .kind("kind_of_child")
            .newKey("id_of_child");
    Entity entity = Entity.builder(key)
            .set("x", 1)
            .set("y", 1)
            .set("z", 1).build();

    datastore.put(entity);