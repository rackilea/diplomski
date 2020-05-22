Map<String, List<String>> map = new HashMap<String, List<String>>();
...
List<String> list = new ArrayList<String>();
list.add(parts[1]);
...add all tokens to list
map.put(parts[0], list);