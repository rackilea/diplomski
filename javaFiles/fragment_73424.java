Map<Long, String> entryMap = new HashMap<Long, String>();
[...]
if (!entryMap.containsKey(nr)) {
     entryMap.put(nr, name);
     forward(nr, name, id);
} else 
     System.out.println("Entry with number " + nr + " already added to .csv file");