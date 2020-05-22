private void jButtonCounterMouseClicked(java.awt.event.MouseEvent evt) {
  int index = Integer.parseInt(jLabel4.getText().split("\\.|\\:|\\)", 2)[0]);
  if (index < questions1.length) {
    jLabel4.setText(questions1[index]);
  }
  if (index < answers1.length) {
    jLabel5.setText(answers1[index]);
  }
}