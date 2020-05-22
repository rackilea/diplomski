@Override
protected void process(List<Vector> rowsList)
{
   for(Vector row : rowsList){
       DefaultTableModel tModel = (DefaultTableModel)jTable1.getModel();
       tModel.addRow(row);            
   }
}