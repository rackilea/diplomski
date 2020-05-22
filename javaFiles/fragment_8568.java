GridPane grid = new GridPane();
ColumnConstraints cconstraints = new ColumnConstraints(10);
RowConstraints rconstraints = new RowConstraints(10);
grid.getColumnConstraints().addAll(cconstraints, cconstraints);
grid.getRowConstraints().addAll(rconstraints, rconstraints);
grid.setGridLinesVisible(true);