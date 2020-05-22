Map<String,Object> map = new HashMap<String,Object>();
A a = new A();
a.name = "a";
map.add("a", a);

B b = new B();
b.name = "b";
map.add("b", b);

a.v_key = "b";
b.v_key = "a";