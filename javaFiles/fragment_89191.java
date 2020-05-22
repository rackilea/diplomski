Map<String, String[]> result = new TreeMap<>();


for(String[] s : source) {
    if(!result.containsKey(s[0])){
        result.put(s[0], s);
    } else if (Integer.valueOf(result.get(s[0])[3]) < Integer.valueOf(s[3])) {
        result.put(s[0], s);
    }
}

for(String k : result.keySet()) {
    System.out.println(k + ": " + Arrays.toString(result.get(k)));
}