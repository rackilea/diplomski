ArrayList<String> myList;
HashMap<String, List<String>> myMap = new HashMap<>();
for(String s : myList)
{
   String[] split = s.split(";");
   List<String> bucket = myMap.get(split[0]);
   if(bucket == null) 
   {
       bucket = new ArrayList<String>();
       myMap.put(split[0], bucket);
   }

   bucket.add(split[1]);
}