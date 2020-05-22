public int getHighestSpeed(Auto[] autos) {

  int highest = 0;  //use a variable to hold the highest speed found so far.

  for (Auto auto : autos) {  //loop through all Auto in the array
    if (auto.getSpeed() > highest) {
      highest = auto.getSpeed();  //this Auto is fastest so far
    }
  }

  //how we have the highest speed, return it
  return highest;
}