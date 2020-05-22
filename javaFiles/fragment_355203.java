this.timeTable = new JTable(this.rowData, this.daysOfTheWeek) {
        CellSelectionSet cellSelectionSet = new CellSelectionSet();

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }

        @Override
        public void changeSelection(int rowIndex, int columnIndex, boolean toggle, boolean extend) {
            super.changeSelection(rowIndex, columnIndex, toggle, extend);

            if (toggle) {
                    cellSelectionSet.add(rowIndex, columnIndex);

            } else {
                if (extend) {
                    cellSelectionSet.add(rowIndex, columnIndex);

                } else {
                    // reset
                    cellSelectionSet.clear();
                    cellSelectionSet.add(rowIndex, columnIndex);
                }
            }

      }

        @Override
        public boolean isCellSelected(int row, int column) {
            if (cellSelectionSet.containsOneOrLess()) {
                // show the default
                return super.isCellSelected(row, column);
            }
            return cellSelectionSet.contains(row, column);
        }

    };