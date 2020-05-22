String json = IOUtils.toString(response.getEntity().getContent());
JSONArray array = new JSONArray(json);
for (int i = 0; i < array.length(); i++) {
    JSONObject object = array.getJSONObject(i);
    log.info("the id is {}", object.getInt("id"));
    log.info("the insertDate is {}", object.getString("insertDate"));
    log.info("read is {}", object.getBoolean("read"));
    log.info("the site is {}", object.getString("site"));
    log.info("the Email is {}", object.getString("Email"));
    log.info("the location is {}", object.getString("location"));
}