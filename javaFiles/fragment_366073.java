int row = 0; // move this out to a member variable

String st= JcbSub.getSelectedItem().toString();
jTable3.setValueAt(st, row, 0);    

row ++; // this increment currently has no effect on next method call