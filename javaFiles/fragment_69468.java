public class ImmutablePagedTableModel extends AbstractTableModel {
  private final List<MyBusinessObject> allData;
  private final int pageSize;
  private int pos;  

  public ImmutablePagedTableModel(List<MyBusinessObject> allData) {
    // Copy construct internal list.  Use ArrayList for random access look-up efficiency.
    this.allData = new ArrayList<MyBusinessObject>(allData);
  }

  /**
   * Returns true if the model has another page of data or false otherwise.
   */
  public boolean hasNextPage() {
    return pos + pageSize < allData.size();
  }

  /**
   * Flips to the next page of data available.
   */
  public void nextPage() {
    if (hasNextPage()) {
      pos += pageSize;

      // All data in the table has effectively "changed", so fire an event
      // causing the JTable to repaint.  
      fireTableDataChanged();
    } else {
      throw new IndexOutOfBoundsException();
    }    
  }

  public int getRowcount() {
    return Math.min(pageSize, allData.size() - pos);
  }

  // TODO: Implement hasPreviousPage(), previousPage();
}