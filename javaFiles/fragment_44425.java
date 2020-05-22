ArrayList<Class<? extends Interface1>> classList = new ArrayList<>();

// assume this is allowed:
ArrayList<Class<?>> lessRestrictiveClassList = (ArrayList<Class<?>>) classList;

// now add an element to the less restrictive list
lessRestrictiveClassList.add(String.class);

// and obtain it from the original list
// this code will crash, because String does not implement Interface1
Class<? extends Interface1> cls = classList.get(0);