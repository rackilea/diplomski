JSONObject brand = obj.getJSONObject(Keys.CATEGORY_BRAND);
   JSONObject desc =  obj.getJSONObject(Keys.CATEGORY_DESC);
   String category = obj.getString(Keys.CATEGORY);
   lookupProduct = new LookupProducts(key, brand, desc, category);
   mLookupProducts.add(lookupProduct);

   // iterate every brand key, fetch its value and add in arrayList
   Iterator<String> brandKeys = brand.keys();
   while(brandKeys.hasNext()) {
        String bKey = brandKeys.next();
        mArrayStringLookupProduct.add((String) brand.get(bKey));
   }