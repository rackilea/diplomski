table1 = new JTable(){

public Component prepareRenderer(TableCellRenderer tcr, int row,
    int column) {
    Component c = super.prepareRenderer(tcr, row, column);

    if (isRowSelected(row)) {

        c.setForeground(getSelectionForeground());
        c.setBackground(getSelectionBackground());

    } else {

        c.setForeground(getForeground());
        c.setBackground((row % 2 == 0) ? getBackground()
            : Color.lightGray);
    }

    int rendererWidth = c.getPreferredSize().width;
    TableColumn tableColumn = getColumnModel().getColumn(column);
    tableColumn.setPreferredWidth(Math.max(rendererWidth
        + getIntercellSpacing().width,
        tableColumn.getPreferredWidth()));

DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
table1.getColumnModel().getColumn(column).setCellRenderer(rightRenderer);
return c;
    }

  };;