public class HashMapTest {
public static void main(String[] args) {
    Map<String, String> map = new HashMap<String, String>();
    map.put("c", "ccccc");
    map.put("a", "aaaaa");
    map.put("b", "bbbbb");
    map.put("d", "ddddd");

    List<Map.Entry<String,String>> list = new ArrayList<Map.Entry<String,String>>(map.entrySet());
    Collections.sort(list,new Comparator<Map.Entry<String,String>>() {
        //Ascending order
        public int compare(Entry<String, String> o1,
                Entry<String, String> o2) {
            return o1.getValue().compareTo(o2.getValue());
        }

    });

    for(Map.Entry<String,String> mapping:list){ 
           System.out.println(mapping.getKey()+":"+mapping.getValue()); 
      } 
 }