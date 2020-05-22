ColumnConstraints c1 = new ColumnConstraints();
c1.setHgrow(Priority.NEVER);

ColumnConstraints c2 = new ColumnConstraints();
c2.setHgrow(Priority.ALWAYS);

gridPane.getColumnConstraints().addAll(c1, c2, c1);