class ZippedFile {
   public static final int BEGIN_ERROR = 0;
   public static final int BEGIN_BUSY = 1;
   public static final int BEGIN_OK = 2;
   private int refcount = 0;
   public void wantAccess ();   // synchronized internally
   public int beginAccess ();   // synchronized internally
   public void finishAccess (); // synchronized internally
}