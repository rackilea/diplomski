myGridPane.getRowConstraints().clear();
myGridPane.getColumnConstraints().clear();

int numRow = 10;
int numCol = 20;

for (int i = 0; i < numRow; i++) {
    RowConstraints rConstraint = new RowConstraints();
    rConstraint.setPercentHeight(100);
    myGridPane.getRowConstraints().add(rConstraint);
}

for (int i = 0; i < numCol; i++) {
    ColumnConstraints cConstraint = new ColumnConstraints();
    cConstraint.setPercentWidth(100);
    myGridPane.getColumnConstraints().add(cConstraint);
}