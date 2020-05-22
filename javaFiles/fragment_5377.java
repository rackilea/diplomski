public void setValueAt(Object aValue, int row, int col) { 
      if (col == 3) { 
         data.get(row).setBought((Boolean) aValue); 
          this.fireTableCellUpdated(row, col); 

      } 
  }