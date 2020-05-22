List<String> list1 = new ArrayLis<String>();
list1.add("inst1");
list1.add("inst2");
list1.add("inst3");

List<AnotherType> list2 = new ArrayList<AnotherType>();
list2.add(new AnotherType(1,"inst7"));
list2.add(new AnotherType(1,"inst1"));

Set<String> set1 = new HashSet<>(list1);

for(AnotherType elem : list2) {
     if(set1.contains(elem.getLabel())) {
         //  Do your thing here.
         return true;
     }
}