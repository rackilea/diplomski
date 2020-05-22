EntityOne eo1 = new EntityOne("Entity eo1");
    EntityTwo et1 = new EntityTwo("one");
    EntityTwo et2 = new EntityTwo("two");

    eo1.addEntity(et1);
    eo1.addEntity(et2);
    et1.setEntity(eo1);
    et2.setEntity(eo1);

    EntityOne eo2 = new EntityOne("Entity eo2");
    EntityTwo et3 = new EntityTwo("three");
    EntityTwo et4 = new EntityTwo("four");

    eo2.addEntity(et3);
    eo2.addEntity(et4);
    et3.setEntity(eo2);
    et3.setEntity(eo2);

    session.save(eo1);
    session.save(eo2);