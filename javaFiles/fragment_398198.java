scheamaList.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent evt) {
    try {
      dataset.executeQuery( (String) scheamaList.getSelectedItem());
    } catch (Exception ae) {
      ae.printStackTrace();
     }
  }
  });