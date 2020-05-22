public class WashingMachine {

   private WashingMachineState state;

   public WashingMachine() {
     this.state =  new Idle();
   }        

   protected void changeState(WashingMachineState state) {
     this.state = state;      
   }

   public void openLid(){
     state.openLid(this);
   } 

   public void closeLid(){
     state.closeLid(this);         
   } 
   public void pushStartBtn(){
     state.pushStartBtn(this);
   } 

   public void pushStopBtn(){
     state.pushStopBtn(this);
   } 

   public State getState() {
      return state;
   }

 }