// initialize
ReferenceQueue<Foo> queue = new ReferenceQueue<Foo>();
ArrayList< PhantomReference<Foo>> list=new ArrayList<PhantomReference<Foo>>();

for ( int i = 0; i < 10; i++) {
    Foo o = new Foo( Integer.toOctalString( i));
    list.add(new PhantomReference<Foo>(o, queue));
}

// make sure the garbage collector does it’s magic
System.gc();

// lets see what we’ve got
Reference<? extends Foo> referenceFromQueue;
for ( PhantomReference<Foo> reference : list)
    System.out.println(reference.isEnqueued());

while ( (referenceFromQueue = queue.poll()) != null) {
    System.out.println(referenceFromQueue.get());
    referenceFromQueue.clear();
}