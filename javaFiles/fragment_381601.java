public aspect CFlow {

    public pointcut flow() : cflow(call( * B.methodB() ) ) && !within(CFlow);

    before() : flow() {
        System.out.println( thisJoinPoint );
    }

}