public class Floor{
   private Building building;

   public Floor(Building building){
       this.building = building;
   }

   public void waitForElevator(){
       int floor = this.building.getFloor();
   }
}