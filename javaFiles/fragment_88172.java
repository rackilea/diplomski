int trys = 0;
  while (0 == apprenticeComboBoxZeugnis.getItemCount() && trys < 10000) {
    System.out.println(apprenticeComboBoxZeugnis.getItemCount());
    for (int i = 0; i < apprenticeComboBoxZeugnis.getItemCount(); i++) {
      apprenticeComboBoxZeugnis.setSelectedIndex(i - 1);
      int spacko = getApprenticeCombo();
      if (spacko == lehrlingsid) {
        TableFilterListenerZeugnis tableFilterListenerZeugnis = new TableFilterListenerZeugnis(
            this);
        tableFilterListenerZeugnis.updateNoten();
        break;
      }
    }
    trys++;
  }