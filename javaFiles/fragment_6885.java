ConcurrentMap<String, AtomicReference<Person>> map = new ConcurrentHashMap<String, AtomicReference<Person>>();

String name = "John";

AtomicReference<Person> personRef = map.get(name);
if (personRef == null)
    map.putIfAbsent(name, new AtomicReference<Person>());
personRef = map.get(name);
if (personRef.get() == null)
    synchronized (personRef) {
        if (personRef.get() == null)
            // can take a long time without blocking use of other keys.
            personRef.set(new Person(name));
    }
Person person = personRef.get();