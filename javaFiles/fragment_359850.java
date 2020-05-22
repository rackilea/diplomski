Set<Set<String>> outerSet = new HashSet<String>();
Set<String> innerSet = new HashSet<String>();

innerSet.add("foo");
outerSet.add(innerSet);

// *** BROKEN ***
innerSet.add("bar");       // <- adding element to innerSet changes result of innerSet.hashCode()
outerSet.remove(innerSet); // <- this may or may not work because outerSet is _broken_
// *** BROKEN ***

// *** CORRECT ***
outerSet.remove(innerSet);
innerSet.add("bar");
// now you can put innerSet back in outerSet if necessary