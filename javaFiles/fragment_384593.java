int i= table1.getRowCount()-1;
int j= table1.getColumnCount();
Object [] value = new Object[j];
for(int k = 0 ; k<j ; k++)
{
value[k] = model.getValueAt(i,k);
}