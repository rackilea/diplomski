// converting arraylist to array
    double [][] p1 = new double[dataXY.size()][dataXY.size()];
   for (int i=0; i<dataXY.size(); i++) {
        int x = dataXY.get(i).getX(); int y = dataXY.get(i).getY();
         p1[i][0] = x;
         p1[i][1] = y;
    }