public class MyFavouriteClasses { 
    Set<String> classes; 
    public MyFavouriteClasses() { } 
    public Set populate() { 
        Set<String> classes = new HashSet<String>(); 
        classes = new HashSet<String>(); 
        classes.add("ArrayList"); 
        classes.add("Hashset"); 
        classes.add("Random"); 
        classes.add("AbstractList"); 
        return classes;
    }
}

public class MyFavoriteMapClass {
    Map<String, String> map; 
    public MyFavoriteMapClass() { } 
    public void populate() { 
        MyFavouriteClasses class = new MyFavouriteClasses();
        map = new HashMap<String, String>();
        Set<String> classes = class.populate(); 
        for(String str:classes) {
          map.put(String, (Class)str.getPackage());
        }
    } 
}