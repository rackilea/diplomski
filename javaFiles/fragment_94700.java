TableColumn<ProfilZuordnungTableRowModel, Double> kundenwertColumn = new TableColumn<ProfilZuordnungTableRowModel, Double>();
kundenwertColumn.setText("Kundenwert");

kundenwertColumn.setCellValueFactory(new PropertyValueFactory<ProfilZuordnungTableRowModel, Double>("kundenwert"));
kundenwertColumn.setComparator(new KundenwerComparator());
kundenwertColumn.setCellFactory(new KundenwertCellFactory());