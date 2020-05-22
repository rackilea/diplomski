@ Override
public void cancelEdit() {
    super.cancelEdit();

    this.setText(this.getItem());
    this.textField.setText(this.getItem());
    this.setGraphic(this.getTreeItem().getGraphic());
}