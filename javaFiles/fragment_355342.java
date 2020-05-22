for(Point p : defensePossibilities.keySet())
    System.out.println(defensePossibilities.get(p).size());

ArrayList<Point> points = new ArrayList<>();
while(points.isEmpty()) {
    try {
        int random = rnd.nextInt(defensePossibilities.size());
        points.addAll(
                defensePossibilities.get(random));
    } catch(Exception e) {}
}
System.out.println("PointsSize: " + points.size());

int piece2 = rnd.nextInt(points.size());