List<MyClass> l;
Map<String, Myclass> m = new HashMap<MyClass>();
for (MyClass elem : l) { 
    MyClass oldElem = m.put(elem.getName(), elem);
    if (oldElem != null) { 
        elem.setAmount(elem.getAmount() + oldElem.getAmount());
    }
} 
l = new ArrayList<MyClass>(m.values());