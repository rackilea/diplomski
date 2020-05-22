public boolean isValidFloor(floor) {
  // It seems weird to me that 0 is a valid floor.  Is that correct?
  // If floors are zero-indexed, the top floor should actually be numberOfFloors-1.
  return floor >= 0 && floor <= this.numberOfFloors;
}

public void setFloor(int newFloor) {
    if (isValidFloor(newFloor)) {
        this.currentFloor = newFloor;
    }
}