for(CoordenadasP cord : cords) {
     ps.setString(1, cord.getCordNort());
     ps.setString(2, cord.getCordSurr());

     ps.addBatch();
}