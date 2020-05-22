int chol = 0;
int hdl = 0;
int age = 0;
try {

                    age = Integer.parseInt(selectedAge.toString());
                    chol = Integer.parseInt(cholEdit.getText().toString());
                    hdl = Integer.parseInt(hdlEdit.getText().toString());

}

catch (Exception e) {
     chol = 0;
     hdl = 0;
     age = 0;
}