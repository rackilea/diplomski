String myLabel = 
      // 4
      label.getText() + "\n\n" + 
      // 7:00
      (String)boxTimes.getSelectedItem() + "\t" +
      // - Going out....
      "- " + input;

label.setText(myLabel);