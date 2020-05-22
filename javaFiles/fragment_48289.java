void b() {
   try {
     foobar();
   } catch(Exception e) {
     // Stack trace for e:
     // foobar()
     // b()
     // a()
     throw new RuntimeException("error",e); 
  }
}

void a() {
  try {
    b(); 
  } catch(Exception e) {
   // Stack trace for e
   // b()
   // a() 
   // Cause:
   // foobar()
   // b() - repeating line
   // a() - repeating line
   e.printStackTrace();
  } 
}