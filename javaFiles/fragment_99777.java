HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
String key = "myWord";
hashmap.put(key, 1);
Integer tmp = null;
// lets increment value if exist in map or put new value if doesn't exits in map
if ((tmp = hashmap.get(key)) != null) {
    //if map contains word
    hashmap.put(key, tmp + 1);
} else {
    //if word is new, map does't contain it as key 
    hashmap.put(key, 1);
}
System.out.println(hashmap);
//out ->{myWord=2}