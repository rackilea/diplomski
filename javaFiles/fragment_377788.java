patients = new JTable(model);
patients.setShowGrid(false);
patients.setShowHorizontalLines(false);
patients.setShowVerticalLines(false);
patients.setRowMargin(0);
patients.setIntercellSpacing(new Dimension(0, 0));
patients.setFillsViewportHeight(true);
TableRowSorter<PatientTableModel> sorter = new TableRowSorter<>(model);
patients.setRowSorter(sorter);