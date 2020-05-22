@SuppressWarnings("serial")
class Zeichnen extends JPanel {
   private static final String DOWN = "down";

   public Zeichnen() {
      int condition = WHEN_IN_FOCUSED_WINDOW;
      InputMap inputMap = getInputMap(condition);
      ActionMap actionMap = getActionMap();

      inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), DOWN);
      actionMap.put(DOWN, new AbstractAction(DOWN) {
         {
            putValue(ACTION_COMMAND_KEY, DOWN);
         }

         @Override
         public void actionPerformed(ActionEvent evt) {
            System.out.println(evt.getActionCommand());
         }
      });
   }
}