String Filename="json_log_text";
       JSONObject jobject=new JSONObject();
       JSONArray jarray=new JSONArray();
       jobject.put("User_id",jTextField1.getText());
       jobject.put("Password",jPasswordField1.getText());
       jarray.add(jobject);

   FileWriter writer=new FileWriter(("D:\\file store\\"+Filename+".txt"),true);
   writer.write(jobject.toJSONString());
   writer.flush();