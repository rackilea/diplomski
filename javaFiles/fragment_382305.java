Gson gson = new Gson();
Type type = new TypeToken<Map<String, Object>>() {}.getType();

Map<String, Object> data = gson.fromJson(json, type);
ArrayList<Map<String, String>> list = (ArrayList<Map<String, String>>) (data.get("links"));
for (Map<String, String> map : list) {
    if (map.get("rel").equals("approval_url")) {
        System.out.println(map.get("href"));
        break;
    }
}