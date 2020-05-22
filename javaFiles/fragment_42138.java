public static int min (int x, int y, int z) {
  int Min =  (y>x)?x:y;
  Min = (z>Min)?Min:z;
  return Min;
} 

public static int max (int x, int y, int z) {
  int Max =  (y>x)?y:x;
  Max = (z>Max)?z:Max;
  return Max;
} 

public static int average (int x, int y, int z) {
  return (x+y+z)/3;
}