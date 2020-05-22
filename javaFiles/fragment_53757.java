Person p = new Person();
WeakHashMap<Person, PersonMetadata> map = new WeakHashMap<>();
PersonMetadata meta = new PersonMetadata("Geek");
map.put(p, meta);
WeakReference<?> personRef = new WeakReference<>(p);
WeakReference<?> metaRef = new WeakReference<>(meta);
p = null;
meta = null;
while(personRef.get() != null) System.gc();
System.out.println("Person collected");
for(int i = 0; metaRef.get() != null && i < 10; i++) {
    System.out.println("PersonMetadata not collected");
    System.gc();
    Thread.sleep(1000);
}
System.out.println("calling a query method on map");
System.out.println("map.size() == "+map.size());
System.gc();
System.out.println("PersonMetadata "+(metaRef.get()==null? "collected": "not collected"));