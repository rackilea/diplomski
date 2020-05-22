static final DEBUG = false;

 public void frobnicate() {
   if (DEBUG) {
     doExpensiveFrobnicationDebugOperation();
   }
   doActualFrobnication();
 }