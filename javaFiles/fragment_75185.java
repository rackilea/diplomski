class SomeClass {

    JFrame f=...;
    JComboBox cb=new ...;

    ...

    public void someMethod() {
       AddEmployerDialog addEmpDialog=new AddEmployerDialog(f);//wont return until exited or new name added

       String nameAdded=addEmpDialog.getRecentName();//get the name that was added

      //clear combobox of all old entries
      DefaultComboBoxModel theModel = (DefaultComboBoxModel)cb.getModel();
      theModel.removeAllElements();

       //refresh combobox with the latest names from db
       fillCombo();

       //now we set the selected item of combobox with the new name that was added
       cb.setSelectedItem(nameAdded);
  }

}

class AddEmployerDialog {

    private JDialog dialog;
    private String empName;//emp name will be assigned when save is pressed or whatever

    public AddEmployerDialog(JFrame frame) {

        dialog=new JDialog(f);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setModal(true);//so that we dont return control until exited or done
        //add components etc
        dialog.pack();
        dialog.setVisible(true);

    }

    public String getRecentName() {
        return empName;
    }

}