ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
Object object = new Object() {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize()");
    }
};
PhantomReference<Object> phantomReference = new PhantomReference<>(object, referenceQueue);
object = null;
System.gc();
Thread.sleep(1_000);
System.gc();
Thread.sleep(1_000);
System.out.println("isEnqueued() after GC: " + phantomReference.isEnqueued());
Reference reference = referenceQueue.poll();
if(reference != null) {
    System.out.println("isEnqueued() after poll(): " + phantomReference.isEnqueued());
}