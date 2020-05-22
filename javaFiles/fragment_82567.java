Point p1 = new Point(12,  15);
    Point p2 = new Point(13,  12);
    Point p3 = new Point(14,  15);

    List<Point> list = new ArrayList<>();
    list.add(p1);
    list.add(p2);
    list.add(p3);

    Comparator<Point> comp = new Comparator<Point>() {
        @Override
        public int compare(Point p1, Point p2) {
            return p2.y  == p1.y ? p2.x -p1.x : p2.y-p1.y;
        }
    };
    list.sort(comp);