JSONObject jsonObject=jsonObj.optJSONObject(0);
    JSONArray subArray = jsonObject.getJSONArray("banner");

   // get code key from `jsonObject`
   String strCode=jsonObject.optString("code");

   // get all images urls from `subArray`
    for(int index=0;index<subArray.length();index++){
      JSONObject imgJSONObject=subArray.optJSONObject(index);
      // get image urls
      String strImgURL=imgJSONObject.optString("image");

     }