public class MyTableModel extends AbstractTableModel
{
  protected List<MyObject> rows;

  public MyTableModel()
  {
    rows = new ArrayList<MyObject>();
  }

  public void add(MyObject obj)
  {
    rows.add(obj);
  }

  @Override
  public int getRowCount()
  {
    return rows.size();
  }

  @Override
  public int getColumnCount()
  {
    // This value will be constant, but generally you'd also
    // want to override getColumnName to return column names
    // from an array, and in that case you can return the length
    // of the array with column names instead
    return 2;
  }

  @Override
  public Object getValueAt(int row, int column)
  {
    MyObject obj = rows.get(row);

    // Change this to match your columns
    switch(column) {
      case 0: return obj.getId();
      case 1: return obj.getName();
    }

    return null;
  }
}