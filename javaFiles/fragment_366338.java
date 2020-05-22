radius = 1
while(true) {
    Set<Square> squares = difference(
         squaresContainedIn(radius), 
         squaresContainedIn(radius - 1));
    busStop = findNearest(coords, squares);
    if(busStop != null) {
        return busStop;
    }
    radius ++;
}