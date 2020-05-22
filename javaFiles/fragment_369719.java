public Map getUserMenu(){
  Map res = null;
  try {
    Object o = JSONUtil.deserialize(json);
    res = (Map)o;
  } catch (JSONException e) {
    e.printStackTrace();
  }
  return res;
}