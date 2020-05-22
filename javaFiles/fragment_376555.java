C c1 = listOfAObjects.stream()
        .flatMap(a -> a.getList().stream())
        .flatMap(b -> b.getPr().stream())
        .filter(c -> c.getName().equalsIgnoreCase(name))
        .findFirst()
        .orElse(null);