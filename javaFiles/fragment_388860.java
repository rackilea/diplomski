//here jsonString is your json in string format

           JSONObject obj3=new JSONObject(jsonString);
           JSONObject obj4=null;
           //Getting all the keys inside json object with keys- from and to
              Iterator<String> keys= obj3.keys();
              while (keys.hasNext()) 
             {
                   String keyValue = (String)keys.next();
                   obj4 = obj3.getJSONObject(keyValue);
                   //getting string values with keys- from and to
                   String from = obj4.getString("from");
                   String to = obj4.getString("to");
                   int hourstart = Integer.parseInt(from);
                   int hoursclose = Integer.parseInt(to);
                   System.out.println("From : "+ hourstart +" To : "+ hoursclose);
             }