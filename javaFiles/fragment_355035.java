try{
 row=br.readLine();
            JSONArray root = (JSONArray) JSONValue.parseWithException(row);

            for (int i=0;i<root.size();i++)
            {

            JSONObject rootObj = (JSONObject) root.get(i);
            String fullname=(String) rootObj.get("fullname");

            System.out.println (fullname);
            }
    }catch(Exception e)
         {
        e.printStackTrace();
        }