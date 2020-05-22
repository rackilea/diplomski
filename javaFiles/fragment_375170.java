Form form = new Form("form") {

   @Override
   public void onSubmit() {
      // do your stuff
   }

   @Override
   public void onError() {
      // you get here in case of errors (conversion/validatio)
   }
}
add(form);

form.add(...)