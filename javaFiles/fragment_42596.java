class MyThing {
      Closeable c;
   }

   Map<Reference<MyThing>, Closeable> m = new HashMap();
   ReferenceQueue<MyThing> reaped = new ReferenceQueue<MyThing>();

   MyThing mt = new MyThing();
   mt.c = new MyClosable();

   Reference<MyThing> pref = new PhantomReference<MyThing>(mt, reaped);
   m.put(pref, mt.c);

   mt = null;


   System.gc();
   Reference<MyThing> rf = reaped.poll();
   while (rf != null) {
     m.get(rf).close(); 
     rf = reaped.poll();
   }