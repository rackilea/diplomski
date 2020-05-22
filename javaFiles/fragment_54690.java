public void builtxsize (String one,String two){
  TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(jtablestate.getModel());
  jtablestate.setRowSorter(sorter);
  RowFilter<TableModel, Object> firstFiler = null;
  RowFilter<TableModel, Object> secondFilter = null;
  List<RowFilter<TableModel,Object>> filters = new 
  ArrayList<RowFilter<TableModel,Object>>();
  RowFilter<TableModel, Object> compoundRowFilter = null;
    try {
      firstFiler = RowFilter.regexFilter(one, indexofcolumn);
      secondFilter = RowFilter.regexFilter(two, indexofcolumn);
      filters.add(firstFiler);
      filters.add(secondFilter);
      compoundRowFilter = RowFilter.andFilter(filters); 
      } catch (java.util.regex.PatternSyntaxException e) {
          return;
      }
  sorter.setRowFilter(compoundRowFilter);
}