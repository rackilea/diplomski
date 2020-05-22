public Coordinate[] getReversedCoordinates(){

  Coordinate[] original = this.getCoordinates();
  Coordinate[] ret = new Coordinate[original.length];

  for(int i =0; i<original.length; i++){
      ret[i] = new Coordinate( original[i].x , original[i].y );
  }

  return ret;

}