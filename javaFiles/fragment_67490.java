final Map<String, ArrayList<SomeClass>> teamMap = new HashMap<>();

final String id = "bla";

Call call = service.getData(id);
call.enqueue(new Callback<List<SomeClass>>() {

   public void onResponse(List<SomeClass> list) {
       teamMap.put(id, list);
   }

   // onError() {}
}