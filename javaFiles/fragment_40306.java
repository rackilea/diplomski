JTable table = new JTable(new ProductTableModel()){
        @Override
        public Component prepareRenderer(TableCellRenderer renderer, int rowIndex,
                int columnIndex) {

            JComponent component = (JComponent) super.prepareRenderer(renderer, rowIndex, columnIndex);  

            int columnCount = getColumnCount();

            if(columnIndex != 0){

                double firstVal = Double.parseDouble(getValueAt(rowIndex, 1).toString());
                for (int i = 2; i < columnCount; i++) {
                    Double cellValue = Double.valueOf(getValueAt(rowIndex, i).toString());
                    if(cellValue < firstVal ){
                        firstVal = cellValue;
                    }
                }                    

                if(firstVal == Double.valueOf(getValueAt(rowIndex, columnIndex).toString()).doubleValue()) {
                    component.setBackground(Color.GREEN);
                } else{
                    component.setBackground(Color.GRAY);
                }
            }

            return component;
        }
    };