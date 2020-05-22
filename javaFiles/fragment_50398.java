public void methodCaller(char aSwitcher) {
      int result = JOptionPane.showOptionDialog(null, "How would you like you insert your data, manually or from a file? ", "Inserting data", 
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] { "Manual", "From a File" }, JOptionPane.NO_OPTION);
      if (result == JOptionPane.YES_OPTION) {
           switch(aSwitcher)
           {
               case 'A':
                   //Going to call methodA from another class
                   break;
               case 'B':
                   //Going to call methodB from another class
                   break;
               case 'C':
                   //Going to call methodC from another class
                   break;
               default:
                   throw new IllegalArgumentExcpetion("No method defined for option" + aSwitcher);
           }


      }
      else if (result == JOptionPane.NO_OPTION) {
           JTextField NameField = new JTextField(); 
           Object[] message = {"Path location:", NameField};
           int result2 = JOptionPane.showOptionDialog(null, message, "Inserting data", 
                     JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] { "Ok", "Locate the file" }, JOptionPane.NO_OPTION);
      }
 }