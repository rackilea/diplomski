// initialize
ReferenceQueue<Foo> queue = new ReferenceQueue<Foo>();
ArrayList< FinalizeStuff<Foo>> list = new ArrayList<FinalizeStuff<Foo>>();
ArrayList<Foo> foobar = new ArrayList<Foo>();

for ( int i = 0; i < 10; i++) {
    Foo o = new Foo( Integer.toOctalString( i));
    foobar.add(o);
    list.add(new FinalizeStuff<Foo>(o, queue));
}

// release all references to Foo and make sure the garbage collector does it’s magic
foobar = null;
System.gc();

// should be enqueued
Reference<? extends Foo> referenceFromQueue;
for ( PhantomReference<Foo> reference : list) {
    System.out.println(reference.isEnqueued());
}

// now we can call bar to do what ever it is we need done
while ( (referenceFromQueue = queue.poll()) != null) {
    ((FinalizeStuff)referenceFromQueue).bar();
    referenceFromQueue.clear();
}