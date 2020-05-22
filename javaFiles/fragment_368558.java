public class RecordViewer extends JDialog {

  JButton next, prev;
  JLabel label;
  int current;
  CDinventoryItem [] items;

  public RecordViewer(CDinventoryItem [] array)
  {
    super(); 
    current = 0; 
    items = array;
    ....