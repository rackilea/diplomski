tx = s.beginTransaction();
    LinkedList<Elements> valves = new LinkedList<>();

    Valve managedV1 = s.merge(v1);
    Valve managedV2 = s.merge(v2);

    valves.add(managedV1);
    valves.add(managedV2);

    managedV1.getElementsGroupsCollection().add(ge);
    managedV2.getElementsGroupsCollection().add(ge);

    ge.setElementsCollection(valves);

    s.save(ge);
    tx.commit();