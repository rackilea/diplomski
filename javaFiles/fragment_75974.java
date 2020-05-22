class Bloat {  // just a heap filler really
    public Reader res;
    private double a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z;

    private final int ii;

    public Bloat(final int ii, Reader res) {
       this.ii = ii;
       this.res = res;
    }
 }

 // as recommended by Tom Hawtin
 class MySoftBloatReference extends SoftReference<Bloat> {
    public final Reader hardRef;

    MySoftBloatReference(Bloat referent, ReferenceQueue<Bloat> q) {
       super(referent, q);
       this.hardRef = referent.res;
    }
 }

 //...meanwhile, somewhere in the neighbouring galaxy...
 {
    ReferenceQueue<Bloat> rq = new ReferenceQueue<Bloat>();
    Set<SoftReference<Bloat>> set = new HashSet<SoftReference<Bloat>>();
    int i=0;

    while(i<50000) {
        set.add(new MySoftBloatReference(new Bloat(i, new StringReader("test")), rq));

        MySoftBloatReference polled = (MySoftBloatReference) rq.poll();

        if (polled != null) {
            // close the reference that we are holding on to
            try {
                polled.hardRef.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        i++;
    }
}