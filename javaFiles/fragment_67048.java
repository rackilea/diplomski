private javax.swing.JTextArea area;
private javax.swing.JCheckBox checkBox;

public String value = "telephone number is 5";

private void boxActionPerformed(java.awt.event.ActionEvent evt) {

    if (checkBox.isSelected()) {
        value = value + "\n" + "coke";
        area.setText(value);
    }

}