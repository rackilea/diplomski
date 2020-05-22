DefaultTableModel model =  new DefaultTableModel(new String[] {"X", "Y", }, 0)
{
        @Override
        public Class<?> getColumnClass(int column) 
        {
              Class<?> returnValue;
              if ((column >= 0) && (column < getColumnCount())) 
              {
                  returnValue = getValueAt(0, column).getClass();
              } 
              else 
              {
                 returnValue = Object.class;
              }

              return returnValue;

       };
    };