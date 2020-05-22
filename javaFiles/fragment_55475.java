CSVReader reader = new CSVReader(new FileReader(file));

            List<String[]> myEntries = reader.readAll();
            String[][] rowData = myEntries.toArray(new String[0][]);

            String[] columnNames = {"People", "Place", "Organisation", "Event", "Mentions"};

            DefaultTableModel tableModel = new DefaultTableModel(rowData, columnNames);

            tableModel.addColumn(""); // What ever name you want to give it...

            Boolean isFirstLine = true;

            for (int row = 0; row < tableModel.getRowCount(); row++) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String finalCell = "";

                for (int col = 0; col < tableModel.getColumnCount() - 1; col++) {
                    finalCell = "Hello";
                }
                tableModel.setValueAt(finalCell, row, tableModel.getColumnCount() - 1);
            }

            JTable table = new JTable(tableModel);