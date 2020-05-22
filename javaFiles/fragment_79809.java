if(command.equals("Align")){
        int currentPosition = 0;
        int spaces = 500 / shapes.size();

        List<Shape> sortedShapes = new ArrayList<Shape>();
        sortedShapes.addAll(shapes);
        Collections.sort(sortedShapes, new Comparator<Shape>() {
            @Override
            public int compare(final Shape object1, final Shape object2) {
                return object1.getX() < object2.getX() ? -1 : object1.getX() == object2.getX() ? 0 : 1;
            }
        });

        for (Shape s : sortedShapes) {
            s.setX(currentPosition);
            currentPosition = s.getX() + spaces;
        }
        repaint();
    }