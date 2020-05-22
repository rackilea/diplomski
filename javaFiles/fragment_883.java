DefaultTableModel  model1 = new DefaultTableModel(rowNames.length, columnNames.length) {
         /**
          * UUID
          */
         private static final long serialVersionUID = 8538648271391086030L;

         @Override
         public boolean isCellEditable(int row, int col) {
             return false;
         }
     };

     JTable  tableAnalytics = new JTable(model1);