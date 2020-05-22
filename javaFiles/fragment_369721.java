JSONArray jArray = new JSONArray(s);

          for(i=0; i < jArray.length(); i++) 
          {

            JSONObject jObject = jArray.getJSONObject(i);
            String name = jObject.getString("name");
            String id= jObject.getString("id");
            System.out.println("id: " + i + " IntelliJ Amiya " + jObject.getString("id"));
            ListItem_Ostan item = new ListItem_Ostan(name,id);
            listItems.add(item);

        }