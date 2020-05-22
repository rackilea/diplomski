public class SomeClass extends JFrame implements ActionListener {
    private DefaultTableModel model;

    public Object getRowData(int row) {
       if (model != null) {
          // return row of data from model here 
       } else {
          // throw some exception
       }
    }


    SomeClass() 
    {

      //code
    }

    public void actionPerformed(ActionEvent ae) 
    {
        if (ae.getSource() == b1)
        {
            showTableData();
        }
     }

    public void showTableData()
    {
        // DefaultTableModel model = new DefaultTableModel();
        model = new DefaultTableModel(); // don't re-declare the model here

        model.setColumnIdentifiers(columnNames);
        table.setModel(model);