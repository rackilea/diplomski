BufferedReader in
   = new BufferedReader(new FileReader("foo.in"));

ArrayList<JSONObject> contentsAsJsonObjects = new ArrayList<JSONObject>();
while(true)
{
  String str = in.readLine();
  if(str==null)break;
  contentsAsJsonObjects.add(new JSONObject(str));
}

for(int i=0; i<contentsAsJsonObjects.size(); i++) 
{ 
  JSONObject json = contentsAsJsonObjects.get(i);
  String lat = json.getString("Lat"); 
  String lng = json.getString("Lng"); 
  Log.i("TAG", lat + lng) 
}