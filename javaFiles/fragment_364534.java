table = new Table(tableModel) {
   protected TableLayout.Constraint createCellConstraint(Object value, int row, int column) {
       TableLayout.Constraint c = super.createCellConstraint(value, row, column);
       c.setWidthPercentage(-2);
       return c;
   }


  ... rest of your code
};