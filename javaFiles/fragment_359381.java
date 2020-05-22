// Build a polygon list
    double [][]distDataProp = new double[][] {{.25,.45, .20},{.56, .89, .45}, {.6, .3,.7}};
    List<Polygon> polygons = new ArrayList<Polygon>();
    for(int i = 0; i < distDataProp.length -1; i++){
        for(int j = 0; j < distDataProp[i].length -1; j++){
            Polygon polygon = new Polygon();
            polygon.add(new Point( new Coord3d(i, j, distDataProp[i][j]) ));
            polygon.add(new Point( new Coord3d(i, j+1, distDataProp[i][j+1]) ));
            polygon.add(new Point( new Coord3d(i+1, j+1, distDataProp[i+1][j+1]) ));
            polygon.add(new Point( new Coord3d(i+1, j, distDataProp[i+1][j]) ));
            polygons.add(polygon);
        }
    }

    // Creates the 3d object
    Shape surface = new Shape(polygons);
    surface.setColorMapper(new ColorMapper(new ColorMapRainbow(), surface.getBounds().getZmin(), surface.getBounds().getZmax(), new org.jzy3d.colors.Color(1,1,1,1f)));
    surface.setWireframeDisplayed(true);
    surface.setWireframeColor(org.jzy3d.colors.Color.BLACK);

    chart = new Chart();
    chart.getScene().getGraph().add(surface);