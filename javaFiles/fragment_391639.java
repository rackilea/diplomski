//....
      int i = 0;
      for (char myChar = 'A'; myChar <= 'Z'; myChar++) {
         final String btnText = String.valueOf(myChar);
         MyKeyBoardAction action = new MyKeyBoardAction(btnText);
         letter[i] = new JButton(action);
         i++;
      }
   }

   private class MyKeyBoardAction extends AbstractAction {
      public MyKeyBoardAction(String name) {
         super(name);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         textArea.append(getValue(NAME).toString());
      }
   }