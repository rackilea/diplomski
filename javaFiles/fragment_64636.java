public static ArrayList<Line> filter(Point p, ArrayList<Line> lines) {
        ArrayList<Line> filtered = new ArrayList<Line>();
        for (Line line : lines)
            if (line.isInInterval(p))
                filtered.add(line);

        return filtered;
    }