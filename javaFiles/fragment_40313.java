Entry<PriorityKey, LinkedHashSet<Value>> e = map.firstEntry(); 
if (e==null) return null; 
Iterator<Value> i = e.getValue().iterator(); 
Value v = i.next(); //must always have at least one element.
i.remove(); 
if (!i.hasNext()) map.remove(e.getKey());
return v;