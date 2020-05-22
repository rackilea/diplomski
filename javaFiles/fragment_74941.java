Object value=tabTask.getValueAt(i,j);
if (value!=null) {
  if (value instanceof String) {
    bfw.write((String)value);
  }
  else if (value instanceof Boolean) {
    bfw.write(Boolean.toString(value));
  }
}