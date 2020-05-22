Set<String> set = new TreeSet<String>();
for (int i = 0; i < contacts.size(); i++) {
       set.add(contacts.get(i).toString());
}

for (String key : set) {
  System.out.println(key);
}