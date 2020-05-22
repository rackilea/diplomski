//Access the label by name.
LabelHandle headerLabel = (LabelHandle) design.findElement("Header Label");
try {
headerLabel.setText("Updated " + headerLabel.getText());
} catch (Exception e) {
// Handle the exception
}