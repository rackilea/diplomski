import java.util.*;

public class Test { 
    public static void main(String[] args) throws Exception {
        new Test();
    }

    public Test() {
        List<Obj> objects = new ArrayList<>();
        objects.add(new Obj("a"));
        objects.add(new Obj("b"));
        objects.add(new Obj("c"));

        List<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("d");
        strings.add("e");

        remove(objects, strings);

        System.out.println(objects);
        System.out.println(strings);
    }

    public void remove(List<Obj> objects, List<String> strings) {
        Map<String, Obj> map = new HashMap<>();
        for (Obj object : objects) {
            map.put(object.str, object);
        }

        Set<String> keys = map.keySet();
        List<String> oldStrings = new ArrayList<>(strings);

        strings.removeAll(keys);
        keys.removeAll(oldStrings);

        objects.clear();
        for (String key: keys) {
            objects.add(map.get(key));
        }       
    }

    public class Obj {  
        public String str;
        public Obj(String str) {
            this.str = str;
        }
        @Override
        public String toString() {
            return str;
        }       
    }
}