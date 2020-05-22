public static void main(String[] args) throws Exception {

    //create a memoizer that performs factorials
    final Memoizer<Integer, Integer> memo = new Memoizer<Integer, Integer> (new Computable<Integer, Integer>() {
        @Override
        public Integer compute(Integer a) {
            int result = 1 ;
            for(int i = 1 ; i < a ; i++){
                result = result*i;
            }
            return result;
        }
    });

    //now call the memoizer
    System.out.println(memo.compute(10));


    //call it with 10 threads concurrently
    ExecutorService exec = Executors.newFixedThreadPool(10);
    ExecutorCompletionService<Integer> compService = new ExecutorCompletionService<Integer>(exec);
    for(int i = 0 ; i < 15 ; i++){
        compService.submit(new Callable<Integer>(){
            @Override
            public Integer call() throws Exception {
                return memo.compute(5);
            }
        });
    }
    exec.shutdown();
    for(int i = 0 ; i < 15 ; i++){
        System.out.println(compService.take().get());
    }
}