ArrayList<MyClass1> obj1 = new ArrayList<MyClass1>();
ArrayList<MyClass2> obj2 = new ArrayList<MyClass2>();

ArrayList<Object> obj3 = new ArrayList<Object>();

obj3.add(obj1); 
obj3.add(obj2);

for (int = 0 ; i < obj3.size() ; i++) {
    Object obj = obj3.get(i);
    if (obj instanceof MyClass1) {
        MyClass1 cls1 = (MyClass1)obj;
        cls1.get()..//You getters and setters
    }
    if (obj instanceof MyClass2) {
        MyClass2 cls2 = (MyClass2)obj;
        cls2.get()..//You getters and setters
    }
}