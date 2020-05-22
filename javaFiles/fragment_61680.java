employee.getPositions.clear(); // delete all existing one
  // add all of them again
 for (long positionId : positionIdList) {
    Position position = entityManager.find(positionId);
    employee.getPositions.add(position);
}