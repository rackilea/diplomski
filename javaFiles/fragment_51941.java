for( int i=0; i<checkBoxPanel.getComponentCount(); i++ ) {
  JCheckBox checkBox = (JCheckBox)checkBoxPanel.getComponent( i );
  if( checkBox.isSelected() ) {
     String option = checkBox.getText();
     // append text, etc
  }
}