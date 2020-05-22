String input = "UK"
for (int i = 0; i < jsonResponse.length(); i++) {
    JSONObject jsonObject = jsonResponse.getJSONObject(i);
    JSONArray brands = jsonObject.getJSONArray("brand");

    for (int j = 0; j < brands.length(); j++) {
       String brand = brands.getString(j);

       if(brand.compareTo(input) == 0){
          System.out.println(jsonObject.getString("Language"));
          break;
       }
    }
}