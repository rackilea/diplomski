JSONArray one = reader.getJSONArray("routes");
      if(one.size()>0)
    {
          for ( i = 0; i < one.length(); i++) {

             two = one.getJSONObject(i);

             three = two.getJSONArray("legs");

            for ( j = 0; j < three.length(); j++) {

               four = three.getJSONObject(j);
               bounds = four.getJSONObject("distance");

                distance[i]=bounds.getString("text");
 }}
else
 {//handle empty json array here
    }