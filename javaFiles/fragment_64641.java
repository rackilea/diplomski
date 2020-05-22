SName = JOptionPane.showInputDialog("Enter Name to find: ");
boolean found = false;
Object info;
for (int i = 0; i < counter; i++) {
  if (entry[i].getName().equals(SName)) {
    found = true;
    info = entry[i].getInfo2();
    break;
  }
}
if (found){
    JOptionPane.showMessageDialog(null, info);
}else{
  JOptionPane.showMessageDialog(null, "Name Not Found!");
}