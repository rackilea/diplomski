Set<String> dupIds = new HashSet<String>();
Set<String> set = new HashSet<String>();

for (Phone p: list) {
  if (set.contains(p.id)) {
     dupIds.add(p.id);
  } else {
     set.add(p.id);
  }
}