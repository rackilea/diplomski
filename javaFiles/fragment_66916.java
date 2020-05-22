// Alternative to Vector:
List<String> list = new ArrayList<>();
list.add("alpha");
for (String s : list) { ... }

// Alternative to Enumeration:
Iterator<String> iterator = list.iterator();
while (iterator.hasNext()) {
     String s = iterator.next();
}