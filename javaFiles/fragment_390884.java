A a new A();
a.setA("aaa");
a.setB(4);

List<A> aList = new ArrayList<A>();
aList.add(a);
 ///    .... 

String a;
int b;

for(A a: aList){
   a = a.getA();
   b = a.getB();
 }