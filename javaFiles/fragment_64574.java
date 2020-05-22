String col[] = {"Pos","Team","P", "W", "L", "D", "MP", "GF", "GA", "GD"};

DefaultTableModel tableModel = new DefaultTableModel(col, 0);
                                            // The 0 argument is number rows.

JTable table = new JTable(tableModel);