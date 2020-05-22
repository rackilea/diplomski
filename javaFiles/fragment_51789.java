Ship[] army = new Ship[2];
army[0] = new Submarine("0");
army[1] = new Destroyer("1");

for( Ship s : army ) {
  s.fire();
}