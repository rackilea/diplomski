class Parse{
 public void parseJson(String response){
  Gson gson=new Gson();
  Box box=gson.fromJson(response,Box.class);
  System.out.println(box.getCategoryId());
 }
}