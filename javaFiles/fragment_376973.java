public class ZMemoryLeak2
extends Object
{

static public synchronized void main(String... args) {
    try { ZMemoryLeak2.class.wait(0); } catch(InterruptedException thr) { System.exit(0); }
    }

}