final String id = "bla";

Call call = service.getData(id);
call.enqueue(new Callback<List<SomeClass>>() {

   public void onResponse(List<SomeClass> list) {
       for (SomeClass c : list) {
           c.setCustomField(id);
       }
   }

   // onError() {}
}