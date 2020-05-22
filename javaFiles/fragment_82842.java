import java.util.*;

//...

Map<String,String> map = new HashMap<String,String>();
map.put("username", "sebastian");
map.put("password", "harrypotter");
System.out.println(map); // prints "{username=sebastian, password=harrypotter}"
System.out.println(map.get("password")); // prints "harrypotter"