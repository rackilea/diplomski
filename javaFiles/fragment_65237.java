JSONObject jsonObject = new JSONObject(Result);
jsonObject
  .getJSONObject("MerchHierarchyEBM")
  .getJSONObject("DataArea")
  .getJSONObject("Division")
  .remove("Group");