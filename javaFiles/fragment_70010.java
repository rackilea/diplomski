final InputContext context = InputContext.getInstance();

jEditorPaneMain = new javax.swing.JEditorPane()
   {
       @Override
        public InputContext getInputContext() {
             return context;
        }
   };