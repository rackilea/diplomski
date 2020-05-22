List<JSONObject> myJSONObjects = new  ArrayList<JSONObject> (productid.size()); 

for(int i=0; i<productid.size(); i++) {
    JSONObject obj = new JSONObject();
    obj.put("productid", productid.get(i) );
    obj.put("qty", qty.get(i));
    obj.put("listprice", listprice.get(i));

   myJSONObjects.add(obj);

}