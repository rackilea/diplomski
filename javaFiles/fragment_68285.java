@Override
public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
    Component comp = super.prepareRenderer(renderer, row, column);
    if (populated) {  //this if was just to make sure that I have data in my table
        /*
        *This piece makes the code ignore the rows that are selected as this approach messes up that blue color that selected rows get
        */
        int[] rows = this.getSelectedRows();
        boolean rowisSelected = false;

        for (int rowIndex : rows) {
            if (row == rowIndex) {
                rowisSelected = true;
                break;
            }
        }
        /*
        *And this is the part that does the coloring
        */
        if (!rowisSelected) {
            Integer status = Integer.parseInt((String) 
            int modelRow = convertRowIndexToModel(row);
            this.getModel().getValueAt(modelRow, Constants.HIDDEN_COLUMN));
            switch (status) {
            case 1:
                comp.setForeground(Color.BLACK);
                comp.setBackground(Color.WHITE);
                break;
            case 2:
                comp.setForeground(Color.LIGHT_GRAY);
                comp.setBackground(Color.WHITE);
                break;
            case 3:
                comp.setForeground(Color.BLACK);
                comp.setBackground(Constants.DOWNLOADED_COLOR);
                break;
            case 4:
                comp.setForeground(Color.LIGHT_GRAY);
                comp.setBackground(Constants.DOWNLOADED_COLOR);
                break;
            }
        }
    }
    return comp;
}