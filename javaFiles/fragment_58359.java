private static List<Privilege> setPrivileges() {

        Privilege parent = setParentPrivilege("Event");
        Privilege parent1 = setParentPrivilege("Deals");
        Privilege parent2 = setParentPrivilege("Movies");
        Privilege parent3 = setParentPrivilege("Restaurant");
        Privilege parent4 = setParentPrivilege("Outdoor");

        Privilege child = setFirstLevel(parent, "Create");
        Privilege child1 = setFirstLevel(parent, "Edit");
        Privilege child2 = setFirstLevel(parent, "Update");
        Privilege child3 = setFirstLevel(parent, "Delete");
        Privilege subchild1 = setSecondLevel(child3,"Sub Delete");

        return Collections.unmodifiableList(
                Arrays.asList(
                        parent,
                        parent1,
                        parent2,
                        parent3,
                        parent4,
                        child,
                        child1,
                        child2,
                        child3,
                        subchild1
        ));
    }

    private static Privilege setParentPrivilege(String name) {
        return new Privilege(name);
    }

    private static Privilege setFirstLevel(Privilege firstLevel, String name) {
        Privilege firstLevelChild = setParentPrivilege(name);
        firstLevelChild.setParentId(firstLevel);
        return firstLevelChild;
    }

    private static Privilege setSecondLevel(Privilege secondLevel, String name) {
        Privilege secondLevelChild = new Privilege(name);
        secondLevelChild.setParentId(secondLevel);
        return secondLevelChild;
    }