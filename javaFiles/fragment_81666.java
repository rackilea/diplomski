public class Table {
  private Map<String, String> map = new HashMap<String, String>();
  private Workbook workbook;

  Table(Workbook workbook) {
    this.workbook = workbook;
    // populate map using workbook
  }

  public Table(InputStream is) {
       this(WorkbookFactory.create(is)) ;
  }

 public Table(File file) {
     this(new FileInputStream(file);
 }
}