simpleModel.addPropertyChangeListener(new PropertyChangeListener() {

     @Override
     public void propertyChange(PropertyChangeEvent evt) {
        txtArea.append("File Text: " + simpleModel.getFileText() + "\n");            
     }
  });