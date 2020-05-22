public class HeaderColumns {

  private String recordColumn = "Record";
  private String firstNameColumn = "FirstName";
  private String lastNameColumn = "LastName";
  private String titleColumn = "Title";
  private String fillerColumn = "Filler";
  private List<ErrorColumns> errorColumns;

  public void addErrorColumns(final ErrorColumns errorColumn) {
    if (errorColumns == null) {
      errorColumns = new ArrayList<>();
    }
    errorColumns.add(errorColumn);
  }
  // getter/setters removed
}