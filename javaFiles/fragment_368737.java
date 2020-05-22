private static List<Permission> set() {

        Permission parent = setParenPermission("Event");
        Permission parent1 = setParenPermission("Deals");
        Permission parent2 = setParenPermission("Movies");
        Permission parent3 =setParenPermission("Restaurant");
        Permission parent4 = setParenPermission("Outdoor");

        Permission child = setFirstLevel(parent, "Create");
        Permission child1 = setFirstLevel(parent, "Edit");
        Permission child2 = setFirstLevel(parent, "Update");
        Permission child3 = setFirstLevel(parent, "Delete");
        Permission subchild1 = setSecondLevel(child3,"Sub Delete");

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

    private static Permission setParentPermission(String name) {
        return new Permission(name);
    }

    private static Permission setFirstLevel(Permission firstLevel, String name) {
        Permission firstLevelChild = setParentPermission(name);
        firstLevelChild.setParentId(firstLevel);
        return firstLevelChild;
    }

    private static Permission setSecondLevel(Permission secondLevel, String name) {
        Permission secondLevelChild = new Permission(name);
        secondLevelChild.setParentId(secondLevel);
        return secondLevelChild;
    }