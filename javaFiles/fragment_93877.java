public class SyncTest {

    private Long value;

    public static void main(String[] args) {
        new SyncTest().testLock();
    }

    public SyncTest() {
        value = new Long(1);
    }

    private void testLock() {
        synchronized (this.value) {
            this.value = new Long(15);
        }
    }
}

  private void testLock();
     0  aload_0 [this]
     1  getfield t1.SyncTest.value : java.lang.Long [27] // push value field to operand stack
     4  dup // duplicate value field push it to operand stack
     5  astore_1 // store the top of the operand stack at [1] of local variable array (which is the duplicated value field)
     6  monitorenter // aquire lock on top of the operand stack 
     7  aload_0 [this]
     8  new java.lang.Long [22]
    11  dup
    12  ldc2_w <Long 15> [31]
    15  invokespecial java.lang.Long(long) [24]
    18  putfield t1.SyncTest.value : java.lang.Long [27]
    21  aload_1 // load the [1] of local variable array to the operand stack (which is the duplicated value field previously stored)
    22  monitorexit // release the lock on top of the operand stack
    23  goto 29
    26  aload_1
    27  monitorexit
    .....