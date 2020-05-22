List<Key.ComplexKey> keys = cloudant.getViewRequestBuilder("categoryDesign", "categoriesNoDups")
   .newRequest(Key.Type.COMPLEX, Number.class)
   .group(true)
   .build()
   .getResponse()
   .getKeys();
   for (Key.ComplexKey key : keys) {
       JSONArray keyValues = new JSONArray(key.toJson());
       System.out.println("title = " + keyValues.getString(0));
       System.out.println("parentnode = " + keyValues.getString(1));
   }