Person p = new Person();
WeakHashMap<Person, PersonMetadata> map = new WeakHashMap<>();
PersonMetadata meta = new PersonMetadata("Geek");
map.put(p, meta);
WeakReference<?> ref = new WeakReference<>(p);
p = null;
while(ref.get() != null) System.gc();
System.out.println(map.containsValue(meta)? "Value present": "Value gone");