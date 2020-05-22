simpleModel.addPropertyChangeListener(new PropertyChangeListener() {

     @Override
     public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equale(SimpleModel.FILE_TEXT)
            txtArea.append("File Text: " + simpleModel.getFileText() + "\n");            
     }
  });