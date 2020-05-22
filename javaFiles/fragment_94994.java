private void jButtonCounterMouseClicked(java.awt.event.MouseEvent evt) {
  int count = Integer.parseInt(jLabelCounter.getText());
  count += 1;
  jLabelCounter.setText(count);
  //Condensed: jLabelCounter.setText(Integer.parseInt(jLabelCounter.getText()) + 1);
}