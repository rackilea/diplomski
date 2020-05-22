for (int i = 0; i < response.length(); i++) {
    JSONObject jsonObject = response.getJSONObject(i);

    Target targetObject = new Target();
    targetObject.setTargetId(jsonObject.getString("target_id"));
    targetObject.setTargetName(jsonObject.getString("target_name"));        

    target.add(targetObject);
}