for (int a = 0; a < jsonArray.length(); a++) {
 JSONObject obj = jsonArray.getJSONObject(a);
 System.out.println("Object Value " + a + " " + obj.toString());

 DailyMovie movie = new DailyMovie();

 movie.setId(obj.getString("id"));                        
 movie.setTitle(obj.getString("title"));                      
 movie.setOwner(obj.getString("owner"));                                  
 movie.setChannel(obj.getString("channel"));

 // adding movie to movies array
 movieList.add(movie);

}