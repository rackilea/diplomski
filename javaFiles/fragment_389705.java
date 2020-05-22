JSONObject json = yourJSON;
if(json != null && !json.isNull(KEY_SUCCESS)){
   //Wahetever you need
   String value = json.getString(KEY_SUCCESS);
   if(value != null && value.length > 0){
       //You will fall here only if there's a value...
   }
}