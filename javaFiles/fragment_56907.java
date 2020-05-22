public Class GameEngine {
   .
   .
   private ArrayList<Moveable> movableObjects = .....
   .
   .

   public void gameUpdate() {
       for (Moveable moveableObj : movableObjects) {
           MoveableObject movementData = moveableObj.getMovementData();
           // Process and update as required using the given data
       }
}