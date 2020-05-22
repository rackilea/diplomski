String user_id=jTextField1.getText();
  String Password=jPasswordField1.getText();

              String Filename1="json_log_text_parse";
           JSONParser parser=new JSONParser();



            JSONObject jobject1=new JSONObject();
           JSONArray jarray1=new JSONArray();
            jobject1.put("User_id",jTextField1.getText());
       jobject1.put("Password",jPasswordField1.getText());
       jarray1.add(jobject1);
       FileWriter writer1 =new FileWriter(Filename,true);
       BufferedWriter bf2=new BufferedWriter(writer1);
       PrintWriter pw=new PrintWriter(bf2);

       pw=new PrintWriter(new FileOutputStream(new File("D:\\file store\\"+Filename1+".txt"),true));



              for (Object o:jarray1)
           {

               JSONObject jsonobject=(JSONObject) o;


                user_id=(String) jsonobject.get("User_id");
               pw.print("User_id:"+user_id+"\n");


              Password=(String) jsonobject.get("Password");
               pw.print("Password:"+Password+"\n");



           }

                pw.println();
                pw .close();