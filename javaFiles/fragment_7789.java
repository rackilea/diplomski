JSONArray  albums = reader.getJSONArray("map");

           // looping through All albums
           for( j= 0; j < albums.length(); j++){
               JSONObject codes = albums.getJSONObject(j);

               String album_id = codes.getString("location");

               album_id="["+album_id+"]";
              JSONArray jsonArray = new JSONArray(album_id); 
               for( k= 0; k < jsonArray.length(); k++){
                  JSONObject codess = jsonArray.getJSONObject(k);

         distance[k] = codess.getString("id");
           }
           }