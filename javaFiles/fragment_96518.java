static class AClass {
    private String name;
    private AClass superClass;

    public AClass(String name) {
        this.name = name;
    }

    public void setSuperClass(AClass superClass) {
        this.superClass = superClass;
    }

    @Override
    public String toString() {
        return name + (superClass != null ? " -> " + superClass : "");
    }
}

// return an object from the map if present; otherwise create, insert and return a new one
private static AClass getOrCreate(String name, Map<String, AClass> map) {
    AClass result = map.get(name);
    if (result == null) {
        result = new AClass(name);
        map.put(name, result);
    }
    return result;
}

public static void main(String[] args) {
    String[] arr = {"A -> B", "C -> D", "D -> E", "B -> C"};
    Map<String, AClass> map = new HashMap<>();

    for (String s : arr) {
        String[] split = s.split("\\s+->\\s+"); // split into [subclass, superclass]
        AClass superClass = getOrCreate(split[1], map);
        getOrCreate(split[0], map).setSuperClass(superClass);
    }
    for (AClass c : map.values()) {
        System.out.println(c);
    }
}