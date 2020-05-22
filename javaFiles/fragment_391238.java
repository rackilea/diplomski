public List<Integer> getIndexesOfCategory(JSONArray jsonArray,String category) {
        List<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            if (category.equals(jsonObject.getString("category"))) {
                indexes.add(i);
            }
        }
        return indexes;
    }