PathChildrenCache pathCache = new PathChildrenCache(curator, "/nodes", true);
pathCache
    .getListenable()
    .addListener((curator, event) -> {
        if (event.getType() == Type.CHILD_REMOVED) {
            System.out.println("Child has been removed");
        }
    });
pathCache.start();