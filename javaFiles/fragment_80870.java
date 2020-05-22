Map<Class<? extends Parent>, Supplier> getValueMap = new HashMap<>();

getValueMap.put(ChildA.class, () -> { return ((ChildA) parent).getValue(); });
getValueMap.put(ChildB.class, () -> { return ((ChildB) parent).getValue(); });
getValueMap.put(ChildC.class, () -> { return ((ChildC) parent).getValue(); });

getValueMap.get(parent.getClass()).get();