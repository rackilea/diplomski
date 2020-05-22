try{
    for( int i=0; i < sectionJsonArr.length(); i++){
      JSONObject data = obj.optJSONObject(i);
      Log.d("json-array",data+"");
      String b_certificate_no = data.getString("id_number");
      if (student_birth_certfct_number.equals(b_certificate_no)){
         Log.d("text","inside if");
             //TO-DO CODE
      }
    }
}catch(JSONException e){
  e.printStackTrace();
}