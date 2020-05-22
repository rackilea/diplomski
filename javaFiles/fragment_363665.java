if (!element.isNull("tags")) {
    JSONObject tags = element.getJSONObject("tags");
    String maxspeed = tags.getString("maxspeed");
    txtSpeed.setText(maxspeed+" here");
} else {
    //Your error handling here...
}