JSONArray  pages     =  new JSONArray(jsonString);
            for (int i = 0; i < pages.length(); ++i) {
                JSONObject rec = pages.getJSONObject(i);
                JSONObject jsonPage =rec.getJSONObject("page");
                String address = jsonPage.getString("url");
                String name = jsonPage.getString("name");
                String status =  jsonPage.getString("status");
}