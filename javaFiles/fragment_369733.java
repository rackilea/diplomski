public void actionPerformed(ActionEvent event) 
  {
      a = firstVar.getText();
      y = Integer.parseInt(txtSecond.getText());
      expo = Integer.parseInt(exp.getText());

      if(a.matches(/*Some REGEX*/)) {
          outputExpanded.setText(expand());
      }
      else {
          //Use the JDialog
      } 
  }