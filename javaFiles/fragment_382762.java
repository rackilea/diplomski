SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
Date validityDate = null;
Date nextDueDate = null;
try {
   validityDate = sdf.parse(mValidity.getText().toString());//string value like "25-May-2016"
   nextDueDate = sdf.parse(mDueDate.getText().toString());
   int validate = validate(validityDate, nextDueDate);
   Toast.makeText(getApplicationContext(),""+validate,Toast.LENGTH_SHORT).show();
} catch (Exception ex) {
   Toast.makeText(getApplicationContext(), ex.toString(), Toast.LENGTH_SHORT).show();
}