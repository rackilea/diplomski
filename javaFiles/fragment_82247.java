TableModel model = table.getModel();

for( int i = 0; i < model.getRowCount(); i++ )
{
   for( int i = 0; i < model.getColumnCount(); j++ )
   {
   //Create your File Writer
   fileWriter.write( model.getValueAt( i, j );
   }
}