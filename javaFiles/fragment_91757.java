static private void tryFibo(FunctionalSequence<BigInteger> fiboSequence, int i){
    long startTime = System.nanoTime();
    long endTime;
    try {
        fiboSequence.get(i);
        endTime = System.nanoTime();
        System.out.println("repeated timing for f("+i+")=" + (endTime-startTime)/1000000.+" ns");
    } catch (StackOverflowError e) {
        endTime = System.nanoTime();
        //e.printStackTrace();
        System.out.println("failed counting f("+i+"), time=" + (endTime-startTime)/1000000.+" ns");
    }       
}