String[] aHeaders = {"Name","ID","Number 1","Number 2","Time","Date"};

Object[][] aData = new Object[15][6];

///////Data////////
aData[0][0] = "John";
aData[0][1] = "JS96";
aData[0][2] = "1";
aData[0][3] = "186";
aData[0][4] = "1h 23m";
aData[0][5] = getJavaDate("12-11-2015");
...

DefaultTableModel model = new DefaultTableModel(aData, aHeaders)
{
         @Override
        public Class<?> getColumnClass(int column) 
        {
            switch (column)
            {
                case 5: return Date.class;
                default: return Object.class;
            }
        }
};

myTable = new JTable( model );