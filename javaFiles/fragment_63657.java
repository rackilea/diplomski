private void listKurserValueChanged(javax.swing.event.ListSelectionEvent evt) {
    System.out.println("" + ((JList)evt.getSource()));

    JList changedList = (JList)evt.getSource();
    if (listKurser == changedList) {
        //listKurser was changed
    }
}