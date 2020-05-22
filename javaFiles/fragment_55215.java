public X getA(String x, String y){
   X a = new A();
   // specificities for A ...
   ... 
   // common processing
   commonForGet(a);
   return a;
}

public X getB(String x, String y){
   X b = new B();
   // specificities for B ...
   ... 
   // common processing
   commonForGet(b);
   return b;
}

private void commonForGet(X x){
   ...
}