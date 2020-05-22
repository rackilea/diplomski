Set<Point> points = new HashSet<>();
    points.add(new Point(3,4));
    points.add(new Point(5,6));
    points.add(new Point(1,2));
    points.add(new Point(3,5));

    System.out.println(points.contains(new Point(3,4)));
    System.out.println(points.contains(new Point(1,2)));
    System.out.println(points.contains(new Point(2,4)));