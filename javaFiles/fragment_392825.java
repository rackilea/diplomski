//member variable
boolean isChanging = false;

//later.... make this same change in both ListSelectionListeners!
jList2.addListSelectionListener(new ListSelectionListener() {

 public void valueChanged(ListSelectionEvent e) {
      if (!isChanging) {
        isChanging = true;
        jList1.clearSelection();
        isChanging = false;
      }
 }