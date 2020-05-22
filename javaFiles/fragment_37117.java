Map<Integer, String> map = new HashMap<Integer, String>();
int i = 0;
for (String name : names) {
    map.put(i++, name);
}

System.out.println(map);