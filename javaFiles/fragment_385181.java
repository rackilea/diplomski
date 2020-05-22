Map<String, Comparator<Enemy>> comparators = new HashMap<>();

comparators.put("health", new Comparator<Enemy>() {
    @Override
    public int compare(Enemy o1, Enemy o2) {
        if (o1.health < o2.health)
            return -1;
        if (o1.health > o2.health)
            return 1;
        return 0;
    }
});

comparators.put("x", new Comparator<Enemy>(){
    @Override
    public int compare(Enemy o1, Enemy o2) {
        if (o1.loc.x < o2.loc.x)
            return -1;
        if (o1.loc.x > o2.loc.x)
            return 1;
        return 0;
    }
});