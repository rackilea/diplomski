interface Something {
    boolean isA();
    int getA();
}

class ClassA implements Something {
    // fields and constructor
    public boolean isA() { return true; }
    public int getA() { return a; }
}

Something[] array = { new ClassA(1), new ClassA(2), new ClassB(0) }; 
ClassA max = null;
for (Something s : array) {
    if (s.isA()) {
       if (max == null || max.getA() < s.getA())
           max = s;
    }
}