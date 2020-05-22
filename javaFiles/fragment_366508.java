Two(One oneInstance, String a, String b, long c, int d, int e)
 {
     this.oneInstance = oneInstance; 
     this.a = a; 
     this.b = b;
     this.c = c; 
     this.d = d; 
     this.e = e;
     oneInstance.add(this);

 }