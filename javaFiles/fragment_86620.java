BufferedReader reader = null;
try {
    reader = new BufferedReader(new FileReader(new File("./FoodItemData.json")));
    Map<String, List<FoodItemData>> object = (new Gson()).fromJson(reader, new TypeToken<Map<String, List<FoodItemData>>>(){}.getType());
    List<FoodItemData> data;
    if (object.values().iterator().hasNext()){
        data = object.values().iterator().next(); // this is you data in your case 3 FoodItemData entries
    }
} catch (FileNotFoundException e) {
    ....
}finally{
    if (reader != null) {
        try {
            reader.close();
        } catch (IOException e) {
            ....
        }
    }
}