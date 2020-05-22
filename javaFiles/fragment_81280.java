ListSelectionModel selectionModel = table.getSelectionModel();
    selectionModel.addListSelectionListener(new ListSelectionListener() {
        public void valueChanged(ListSelectionEvent e) {
            if ( e.getValueIsAdjusting() ){
                return;
             }
             if (e.getSource() == table.getSelectionModel() && 
                 table.getRowSelectionAllowed() ) {
               int selected = table.getSelectedRow();
               System.out.println("Column 1 : " + table.getValueAt(selected, 0));
               System.out.println("Column 2 : " + table.getValueAt(selected, 1));
               System.out.println("Column 3 : " + table.getValueAt(selected, 2));
             }
        }
    });