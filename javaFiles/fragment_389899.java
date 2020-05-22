Component parent = null;  // non-null if being called by a GUI
  queryString = "Do you want fries with that?";
  int intResponse = JOptionPane.showConfirmDialog(parent, queryString,
           "Confirm", JOptionPane.YES_NO_OPTION);
  myResponse = (intResponse == JOptionPane.YES_OPTION) ? "Yes" : "No";
  System.out.println(myResponse);