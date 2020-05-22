public void setAllLabelsForView(String string, Color color){
  for(int i = 0; i < labels.length; i++){
    labels[i].setText(string);
    labels[i].setForeground(color);
  }
}