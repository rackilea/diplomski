Criteria criteria = session.createCriteria(EntityOne.class, "e1");
    criteria.createAlias("e1.entities", "e2");
    criteria.add(Restrictions.eq("e2.name", "two"));

    List<EntityOne> entityList = criteria.list();
    for (EntityOne entityOne : entityList) {
        System.out.println(entityOne.getName());
        for (EntityTwo entity : entityOne.getEntities()) {
            System.out.println("->" + entity.getName());
        }
    }