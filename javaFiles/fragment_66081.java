public class Key { double d1,d2,d2...d11; (constructor, equals, comparable (if want sorted), hash etc) }

Map<Key, Double> map = new TreeMap<>();

Key key = new Key(20, 10, 9, 8, 5, 4, 4, 3, 3, 3, 2);
map.put(key, 1.0);