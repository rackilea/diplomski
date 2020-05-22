if (txtName.getText() !=null && txtAge.getText() !=null) {
    bw.write(txtName_4.getText());
    bw.write(";");
    bw.write(txtAge.getText());
    bw.write(',');
    bw.write(txtAddress.getText());
    bw.write(System.getProperty("line.separator"));