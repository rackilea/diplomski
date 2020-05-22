class MyAction extends AbstractAction {
   private final int iValue;
   private final int jValue;

   public MyAction(int i, int j) {
      this.iValue = i;
      this.jValue = j;
   }

   @Override    
   public void actionPerformed(ActionEvent e) {
      buttonActionPerformed(e, iValue, jValue);
   }
}