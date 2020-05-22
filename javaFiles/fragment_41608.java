if(line != null) {
    JSONObject jo = new JSONObject(line);
    JSONObject graphql = jo.getJSONObject("graphql");
    JSONObject user = graphql.getJSONObject("user");
    name = user.getString("full_name");
}