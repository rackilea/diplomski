public interface WashingMachineState {    
   void openLid(WashingMachine machine);
   void closeLid(WashingMachine machine);
   void pushStartBtn(WashingMachine machine);
   void pushStopBtn(WashingMachine machine);
}