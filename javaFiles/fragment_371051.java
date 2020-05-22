public class WeakSampleMain {
    private static List<WeakReference<Integer>> weakList = new LinkedList<>();
    private static long sum = 0;
    public static void main(String[] args) {
        System.out.println("start");
        int size = 1_000_000;
        for(int i = 0; i < size; i++) {
            Integer value = Integer.valueOf(i);
            weakList.add(new WeakReference<Integer>(value));
        }
        for(int i = 0; i < 10; i++) {
            jitSort();
        }
        GcTask gcTask = new GcTask();
        Thread thread = new Thread(gcTask);
        thread.start();
        for(int i = 0; i < 100000; i++) {
            jitSort();
        }
        thread.interrupt();
        System.out.println(sum);
    }

    public static void jitSort() {
        List<Integer> unwrappedList = unwrapped();
        removeNull();
        Collections.sort(weakList, 
                new Comparator<WeakReference<Integer>>() {

                    @Override
                    public int compare(WeakReference<Integer> o1,
                            WeakReference<Integer> o2) {
                        return Integer.compare(o1.get(), o2.get());
                    }
        }
                );
        for(int i = 0; i < Math.min(weakList.size(), 1000); i++) {
            sum += weakList.get(i).get();
        }
        unwrappedList = null;
//          long value = (sum + unwrappedList.size());
//          if((value * value) % 3 == 2) {
//              for(int i = 0; i < unwrappedList.size(); i++) {
//                  System.out.println(unwrappedList.get(i));
//              }
//          }
    }

    public static List<Integer> unwrapped() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(WeakReference<Integer> ref : weakList) {
            Integer i = ref.get();
            if(i != null) {
                list.add(i);
            }
        }
        return list;
    }

    public static void removeNull() {
        Iterator<WeakReference<Integer>> itr = weakList.iterator();
        while(itr.hasNext()) {
            WeakReference<Integer> ref = itr.next();
            if(ref.get() == null) {
                itr.remove();
            }
        }
    }

    public static class GcTask implements Runnable {
        private volatile int result = 0;
        private List<Integer> stockList = new ArrayList<Integer>();
        public void run() {
            while(true) {
                if(Thread.interrupted()) {
                    break;
                }
                int size = 1000000;
                stockList = new ArrayList<Integer>(size);
                for(int i = 0; i < size; i++) {
                    stockList.add(new Integer(i));
                }
                if(System.currentTimeMillis() % 1000 == 0) {
                    System.out.println("size : " + stockList.size());
                }
            }
        }

        public int getResult() {
            return result;
        }
    }
}