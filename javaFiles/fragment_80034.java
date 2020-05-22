public AssignmentsTableModel(List<Module> modules)
{
  this.rowData = new ArrayList<Module>();

  for (Module module : modules)
  {
    for (Assignment assignment : module.getAssignments())
    {
      rowData.add(new RowData(module, assignment));
    }
  }
}