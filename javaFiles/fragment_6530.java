Map<String, A> as = new HashMap<String, A>;
for (A a: ca) as.put(a.getSomething(), a);
Map<String, B> bs = new HashMap<String, B>;
for (B b: cb) bs.put(b.getSomething(), b);
as.keySet().retainAll(bs.keySet());
ca.retainAll(as.values());