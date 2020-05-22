public static String myQuestion(String question, String[] answers) {
      JPanel panel = new JPanel(new GridLayout(0, 1));
      final ButtonGroup btnGroup = new ButtonGroup();

      for (String answer : answers) {
         JRadioButton radioBtn = new JRadioButton(answer);
         radioBtn.setActionCommand(answer);
         btnGroup.add(radioBtn);
         panel.add(radioBtn);
      }

      String[] options = { "Submit", "Cancel" };
      String initialValue = "Submit";

      int optionResult = JOptionPane.showOptionDialog(null, panel, question,
            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
            options, initialValue);

      // *** code will pause here and wait for the user to handle the modal dialog

      if (optionResult != 0) {
         return ""; // did not select "Submit"
      } else if (optionResult == 0) {
         ButtonModel btnModel = btnGroup.getSelection();
         if (btnModel == null) {
            return ""; // error! nothing selected
         } else {
            return btnModel.getActionCommand();
         }
      }
      return "";
   }

   public static void main(String[] args) {
      String question = "Where is Ulysses S. Grant buried?";
      String[] answers = { "In my back yard", "At the white house",
            "red my lord! No, blue!", "In Grant's tomb", "Who the hell is Ulysses S. Grant?" };
      String selectedString = myQuestion(question, answers);
      System.out.println("Answer selected: " + selectedString);
   }