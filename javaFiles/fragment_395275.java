while (!toCheck.isEmpty()) {
    i++;
    int coords = toCheck.get(0);
    checked.add(coords);        // important
    toCheck.remove(0);          // might as well do this here too
    int x = coords % width;
    int y = coords / width;