static HashMap<String, HashMap<String, String>> extractData(String str) {
  HashMap<String, HashMap<String, String>> data = new HashMap<>();
  for(String s: str.split("\\|")) {
    HashMap<String, String> entries = new HashMap<>();
    for(String s2: s.split(" ")) {
      String[] entry = s2.split("=");
      entries.put(entry[0], entry[1]);
    }
    data.put(entries.get("client_nickname"), entries);
  }
  return data;
}

public static void main(String[] args) {
  String str = "clid=1 cid=2 client_database_id=1 client_nickname=Alessandro client_type=0|clid=2 cid=2 client_database_id=10 client_nickname=Braden client_type=1";

  HashMap<String, HashMap<String, String>> data = extractData(str);
  System.out.println(data.get("Alessandro").get("clid"));
}