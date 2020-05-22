public class MyStructure {
    private Map<String, List<String>> map = new LinkedHashMap<>();

    public MyStructure(String src) {
        parse(src);
    }

    private void parse(String src) {
        String curKey = null;
        List<String> curList = null; 
        for(String line : src.trim().split("\n")) {
            if(line.startsWith("- ")) {
                if(curList == null) {
                    throw new IllegalStateException("Unexpected line");
                }
                curList.add(line);
            } else {
                if(curKey != null) {
                    map.put(curKey, curList);
                }
                curKey = line;
                curList = new ArrayList<>();
            }
        }
        if(curKey != null)
            map.put(curKey, curList);
    }

    public void add(String key, String value) {
        List<String> list = map.get(key);
        if(list == null) {
            list = new ArrayList<>();
            map.put(key, list);
        }
        list.add(0, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Entry<String, List<String>> entry : map.entrySet()) {
            sb.append(entry.getKey()).append("\n");
            for(String item : entry.getValue())
                sb.append(item).append("\n");
        }
        return sb.toString();
    }
}