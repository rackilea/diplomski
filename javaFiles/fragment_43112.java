class MyApp extends SingleFrameApplication {
   private JFrame mainFrame;
   private JLabel label;

   @Override
   protected void startup() {
      getMainFrame().setTitle("BasicSingleFrameApp");
      CustomJPanel panel = new CustomJPanel();
      panel.setButtonAction(getContext().getActionMap(new CustomJPanelActions()).get("doSomething");
      show(panel);
   }

   public static void main(String[] args) {
      Application.launch(BasicFrameworkApp.class, args);
   }
}