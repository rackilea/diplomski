for (Node node : nodeList)
{
  try
  {
     JSONObject obj = new JSONObject();
     obj.put("value", node.getValue());
     obj.put("label", node.getLabel());
     jsonArrayOne.put(obj)
  }
  catch (JSONException e)
  {
     log.info("JSONException");
  }
}