aspect Profile {

    private static Map<String, AtomicInteger> counterMap = new HashMap<String, AtomicInteger>();

    pointcut threadCountPc(test.ThreadCount tc) : execution(* test..*(..)) && @annotation(tc);

    Object around(test.ThreadCount tc) : threadCountPc(tc) {        

        String signature = thisJoinPointStaticPart.getSignature().toString();

        AtomicInteger counter = getCounter(signature);
        int currentValue = counter.incrementAndGet();

        if (currentValue >= tc.value()){
            System.out.println("[Thread Name:" + Thread.currentThread().getName() + 
            "] Method Name:" + signature + ", threadCount:" + currentValue + " exceeds " + tc.value());
        }

        try{
            return proceed(tc);
        }finally{
            counter.decrementAndGet();          
        }
    }

    private static AtomicInteger getCounter(String methodName){
        AtomicInteger value = counterMap.get(methodName);
        if (value == null){
            synchronized (counterMap){
                value = counterMap.get(methodName);
                if (value == null){
                    value = new AtomicInteger(0);
                    counterMap.put(methodName, value);
                }
            }
        }
        return value;
    }
}