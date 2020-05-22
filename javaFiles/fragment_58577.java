int edtPlafond;
try {

    edtPlafond = Integer.parseInt(plafond);

} catch (NumberFormatException e ) {
   e.printStackTrace(); 
   // add proper error handling
}