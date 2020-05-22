TableAdapter ta = new TableAdapter();
int[][] temp = ta.getTableC();
Integer[][] Result = new Integer[temp.length][temp[0].length];
for(int i = 0; i < temp.length; i++){
   for(int j = 0; j < temp[0].length; j++)
      result[i][j] = new Integer(temp[i][j]);
}
Object[] header = {"Column1", "Column2"};
jTable1.setModel(new javax.swing.table.
DefaultTableModel(result, header)