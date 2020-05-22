DT.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
               itemIDlbl.setText(DT.getValueAt(DT.getSelectedRow(), 0).toString());
                 itemNamelbl.setText(DT.getValueAt(DT.getSelectedRow(), 1).toString());
            }
        });