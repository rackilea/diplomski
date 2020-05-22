public class Test{

    public static void main(String[] args) {


        FutureTask<String[]> task = new FutureTask(new MyCallable("a", "b"));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit (task);
        try{
            String[] result = task.get();
            System.out.println(result[0] + result[1]);
        }
        catch(Exception e){
            System.err.println(e);
        }
        es.shutdown();
    }

    public static class MyCallable implements Callable<String[]>
    {

        private String string1, string2;

        public MyCallable (String first, String second)
        {
            string1= first;
            string2 = second;
        }

        @Override
        public String[] call() throws Exception {
            String [] allStrings = new String[2];
            allStrings[0] = string1;
            allStrings[1] = string2;
            return allStrings;
        }
    }
}