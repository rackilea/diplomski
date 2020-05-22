Set<MyKey> set = new HashSet<>(); // or any implementing class

...

MyKey someKey = ...

// Check if your key set doesn't have some key, if so add it to the key set
if (!set.contains(someKey)) {
  set.add(someKey);
}