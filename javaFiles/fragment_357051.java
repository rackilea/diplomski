public class TableWithSelectionLimit extends Table {

    private final int maxSelections= -1;
    private String[] lastSelected;

    public TableWithSelectionLimit(int maxSelections) {
      this.maxSelections = maxSelections;
    }

    @Override
    public void changeVariables(Object source, Map<String, Object> variables) {
      String[] selected = (String[]) variables.get("selected");
      if (selected != null && selected.length > maxSelections) {
        if (lastSelected != null) {
          variables.put("selected", lastSelected);
        } else {
          variables.remove("selected");
        }

        markAsDirty();
      } else {
        lastSelected = selected;
      }

      super.changeVariables(source, variables);
    }
}