@Override
    public void tableChanged(TableModelEvent tme) {
        int row = tme.getFirstRow();
        int col = tme.getColumn();
        int type = tme.getType();
        switch (type) {
            case TableModelEvent.UPDATE:
                final int currentRow = table.convertRowIndexToView(row);
                final int currentColumn = table.convertColumnIndexToView(col);
                if (currentRow == 0) {
                    // if the test fails, I want to move back to the edited cell
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            table.changeSelection(currentRow, currentColumn, false, false);

                        }
                    });
                }
                break;

            // the rest of switch

        } // switch
    } // tableChanged() method