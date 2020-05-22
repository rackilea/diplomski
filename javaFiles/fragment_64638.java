public static void main(String[] args) {
        Line l1 = new Line(new Point(0, 0), new Point(3, 1));
        Line l2 = new Line(new Point(2, 0), new Point(3, 1));

        Line l3 = new Line(new Point(4, 7), new Point(8, 2));
        Line l4 = new Line(new Point(5, 4), new Point(6, 1));

        Line l5 = new Line(new Point(9, 6), new Point(10, 1));
        ArrayList<Line> lines = new ArrayList<Line>();
        lines.add(l1);
        lines.add(l2);
        lines.add(l3);
        lines.add(l4);
        lines.add(l5);
        ArrayList<Line> res = sumAll(lines);
        for (Line line : res)
        {
            System.out.println(line);
        }


    }