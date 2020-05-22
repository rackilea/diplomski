public class App 
{
    public static void main( String[] args ) throws Exception
    {
        File file = new File("input.json");
        String content = new String(Files.readAllBytes(Paths.get(file.toURI())), "UTF-8");
        JSONArray array = new JSONArray(content); //parse your string data to JSON Array
        Map<String, List<Object>> map = new HashMap<>(); //create a HashMap having a key type as String and values as List of Object, 
        //since you are creating array for each key
        for(int i=0; i<array.length(); i++) //looping on all JSON Objects
        {
            JSONObject obj = array.getJSONObject(i);
            for (String key : obj.keySet()) { //looping on all keys in each JSON Object
                if(map.get(key) == null)
                    map.put(key, new ArrayList<Object>()); //initializing the list for the 1st use
                map.get(key).add(obj.get(key));//adding the value to the list of the corresponding key
            }
        }

        //Output:
        for (String key : map.keySet()) {
            System.out.println(key);
            System.out.println(map.get(key));
        }
    }
}