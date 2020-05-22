public List<Point> getUniq() {
    List<Point> result = new ArrayList<>();
    Point lastAdded = null;
    for (int i = 0; i < pointList.size(); i++) {
        if (!points.get(i).equals(lastAdded)) { // previously added point was different
            lastAdded = points.get(i); // update previously added
            result.add(lastAdded); // add to result
        }
    }
    return result;
}