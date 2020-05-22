long edtPlafond;
try {

    edtPlafond = Long.parseLong(plafond);

} catch (NumberFormatException e ) {
   e.printStackTrace();
   // add proper error handling
}