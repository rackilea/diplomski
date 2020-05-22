table.setModel(new DefaultTableModel(
                new Object[][]
                {
                    {null, null},
                }
            ) {
                Class[] columnTypes = new Class[] {
                public Class getColumnClass(int columnIndex) {
                boolean[] columnEditables = new boolean[] {
                public boolean isCellEditable(int row, int column) {
             });