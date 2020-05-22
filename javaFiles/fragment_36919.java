btnprev.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
      dataArrayCurrentIndex--;

      // if you want to do a cyclic loop of the data
      if (dataArrayCurrentIndex < 0) {
        dataArrayCurrentIndex= maxIndex - 1;
      }

      System.out.println("backwards");
      websitetxt.setText(dataArray[dataArrayCurrentIndex].getWebsitename());
      usernametxt.setText(dataArray[dataArrayCurrentIndex].getUsername());
      passwordtxt.setText(dataArray[dataArrayCurrentIndex].getPassword());
      notestxt.setText(dataArray[dataArrayCurrentIndex].getNotes());
    }
});

btnnext.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        dataArrayCurrentIndex++;

        // if you want to do a cyclic loop of the data
        if (dataArrayCurrentIndex >= maxIndex) {
            dataArrayCurrentIndex = 0;
        }

        // etc...
    }
});