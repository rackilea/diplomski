SortedMap<Date, Sequencing> map;

TreeSet<Date> set = new TreeSet();

for(Entry<Date, Sequencing> en: map.entrySet()) {
   set.add(en.getKey())
}