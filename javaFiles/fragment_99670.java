class GetTableValue implements ActionListener{
    public void actionPerformed(ActionEvent e){
        AbstractButton button = (AbstractButton)e.getSource();
        if(e.getActionCommand().equals(button.getActionCommand)){

            int row = table.convertRowIndexToModel(table.getSelectedRow());
            MyAwesomeTableModel model = (MyAwesomeTableModel)table.getModel();

            MyRowData data = model.getRowAt(row);
            JOptionPane.showMessageDialog(null, data);
        }
    }
}