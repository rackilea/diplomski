XYSeriesCollection ds = new XYSeriesCollection();
    XYSeries s1 = new XYSeries("XY data");
    for (int i=0; i<dataXY.size(); i++) {
         int x = dataXY.get(i).getX(); int y = dataXY.get(i).getY();
         s1.add(y, x);
    }
    ds.addSeries(s1);