public class IdleState implements State {    
   public void openLid(WashingMachine machine){
       ...
   }
   public void closeLid(WashingMachine machine){
       ...
   }
   public void pushStartBtn(WashingMachine machine){
      //do processing with machine to begin effectively the washing
         ...
      machine.changeState(new WashingState());
   }

   public void pushStopBtn(WashingMachine machine){
       ...
   }
 }