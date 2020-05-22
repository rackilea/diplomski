Set<String> set = new HashSet<>();
for(int i =0; i < list.size(); i++) {
    if set.contains(list.get(i)) {
         System.out.println(list.get(i)+" is duplicated")
    } else set.add(list.get(i);
}