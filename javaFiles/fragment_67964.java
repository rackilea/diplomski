public void actionPerformed(ActionEvent event) {
  if(wordwrap) wordwrap = false;
  else wordwrap = true;
  textArea.setLineWrap(wordwrap);
  frame.revalidate(); //is preferable but validate() also works.
}