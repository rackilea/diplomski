BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
   StringBuilder b = new StringBuilder();
   String input;

   while ((input = br.readLine()) != null){
        b.append(input);                 
   }

   JSONObject j = new JSONObject(b.toString());

   // this should be in finally block
   br.close();