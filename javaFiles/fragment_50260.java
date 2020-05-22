GridBagLayout gbl = new GridBagLayout();
yourPanel.setLayout( gbl );

//  Set up a grid with 8 columns.
//  The minimum width of a column is 50 pixels

int[] columns = new int[8];
Arrays.fill(columns, 50);
gbl.columnWidths = columns;