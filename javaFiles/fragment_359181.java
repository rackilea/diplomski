List<Recipe> recipesList = new ArrayList<Recipe>();
 HttpEntity jsonObj = response.getEntity();
 String data = EntityUtils.toString(entity);
 Log.d("TAG", data);
 Gson gson = new GsonBuilder().create();
 recipesList = gson.fromJson(data, new TypeToken<List<Item>>() {}.getType());