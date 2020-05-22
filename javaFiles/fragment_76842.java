masterList.put("A", Arrays.asList("123","123","456"));
masterList.put("B", Arrays.asList("123","789","789"));
for (Map.Entry<String, List<String>> e : masterList.entrySet()) {
    String key = e.getKey();
    List<String> val = e.getValue();
    System.out.println(modifier.size());
    for (String s : val) {
        if (modifier.isEmpty())
            finalPNList.add(s);
        else if (!modifier.isEmpty() && masterList.get("A").contains(s)) {
            // s has been added by parent process so SKIP!
            skipped.add(s);
        } else
            finalPNList.add(s);    
    }    
    modifier.add(key);
}