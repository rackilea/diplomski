private void deleteEnemies () {
    List<Actor> actors = getActors();
    List<Actor> toRemove = new ArrayList<Actor>();
    int actorsSize = actors.size();
    Actor first = null, second = null;
    for(int i = 0; i < actorsSize; ++i) {
        first = actors.get(i);
        for(int j = 0; j < actorsSize; ++j) {
            if(i == j) continue;
            second = actors.get(j);
            if(first.intersects(second)) {
                toRemove.add(first);
                toRemove.add(second);

            }
        }
    }
    actors.removeAll(toRemove);
}