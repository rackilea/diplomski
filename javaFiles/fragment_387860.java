private void setComboBoxFocus(JComboBox box) {
    box.addItemListener(
          new ItemListener(){
              public void itemStateChanged(ItemEvent e){
                  if(e.getStateChange() == ItemEvent.SELECTED)
                  {
                      String titleSelected = box.getSelectedItem().toString();
                      System.out.println(titleSelected);
                      box.transferFocus();
                  }
              }
          });
}