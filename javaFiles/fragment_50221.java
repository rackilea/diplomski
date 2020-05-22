class ModelClass {
   int value;
   Action incAction = new AbstractAction("Increment") {
      public void actionPerformed() {
         value++;
         setEnabled(value < 10);
      }
   };

   public Action getIncAction() {
      return incAction;
   }
}

class UIClass {
   void buildMenu() {
      JMenu menu = new JMenu("Model");
      menu.add(model.getIncAction());
   }
}