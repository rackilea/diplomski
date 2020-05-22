public class SizeOfUtil {

    private static final Runtime runtime = Runtime.getRuntime();
    private static final int OBJECT_COUNT = 100000;

    /**
     * Return the size of an object instantiated using the instantiator
     * 
     * @param instantiator
     * @return byte size of the instantiate object
     */      
    static public int execute(Instantiator instantiator) {
        runGarbageCollection();
        usedMemory();
        Object[] objects = new Object[OBJECT_COUNT + 1];
        long heapSize = 0;
        for (int i = 0; i < OBJECT_COUNT + 1; ++i) {
            Object object = instantiator.execute();
            if (i > 0)
                objects[i] = object;
            else {
                object = null;
                runGarbageCollection();
                heapSize = usedMemory();
            }
        }
        runGarbageCollection();
        long heap2 = usedMemory(); // Take an after heap snapshot:
        final int size = Math.round(((float) (heap2 - heapSize)) / OBJECT_COUNT);

        for (int i = 1; i < OBJECT_COUNT + 1; ++i)
            objects[i] = null;
        objects = null;
        return size;
    }

    private static void runGarbageCollection() {
        for (int r = 0; r < 4; ++r){
            long usedMem1 = usedMemory();
            long usedMem2 = Long.MAX_VALUE;
            for (int i = 0; (usedMem1 < usedMem2) && (i < 500); ++i) {
                runtime.runFinalization();
                runtime.gc();
                Thread.yield();
                usedMem2 = usedMem1;
                usedMem1 = usedMemory();
            }
        }
    }

    private static long usedMemory() {
        return runtime.totalMemory() - runtime.freeMemory();
    }
}