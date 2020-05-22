try {
  // do something
} catch (SomeImportantException e) {
  AlertDialog.Builder builder = new AlertDialog.Builder(this);
  builder.setMessage("User friendly text explaining what went wrong.");
  AlertDialog alert = builder.create();
  alert.show();
}