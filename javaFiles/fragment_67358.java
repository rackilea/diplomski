List<String> names = new ArrayList<String>(25);
names.add("Hurzdiirn");
names.add("Alydriira Talabdiira");
names.add("Urlidil Sineth");
names.add("Quavyraen Belarral");
names.add("Belarayne'bryn Agh'Quarbryn");
names.add("Alakgos");
names.add("Sszoj'hrae Laelraema");
names.add("Szornet");
names.add("Filojafay");
names.add("Lltril'net Chaszhrae");

Collections.sort(names);

for (int index = 0; index < names.size(); index++) {
    String name = names.get(index);
    System.out.println("[" + index + "] " + name);
}

int insertAt = Collections.binarySearch(names, "Luke");
if (insertAt < 0) {
    insertAt = (insertAt * -1) - 1;
}

names.add(insertAt, "Luke");

for (int index = 0; index < names.size(); index++) {
    String name = names.get(index);
    System.out.println("[" + index + "] " + name);
}

Collections.sort(names);
for (int index = 0; index < names.size(); index++) {
    String name = names.get(index);
    System.out.println("[" + index + "] " + name);
}